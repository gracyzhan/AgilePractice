var tiles = new Array(),
	flips = new Array('tb', 'bt', 'lr', 'rl'),
	iFlippedTile = null,
	iTileBeingFlippedId = null,
	tileImages = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
	tileAllocation = null,
	iTimer = 0,
	iInterval = 100,
	iPeekTime = 3000,
	checkingTiles = false,
	peekInterval = 1000;

var startTime = null,
    endTime = null,
	totalPuzzleNum = 10,
    totalTileNum = 20,
    attemptedNum = 0,
    solvedNum = 0,
    score = 0;

function getRandomImageForTile() {

    var iRandomImage = Math.floor((Math.random() * tileAllocation.length)),
		iMaxImageUse = 2;

    while (tileAllocation[iRandomImage] >= iMaxImageUse) {
        iRandomImage = iRandomImage + 1;
        if (iRandomImage >= tileAllocation.length) {
            iRandomImage = 0;
        }
    }

    return iRandomImage;
}

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
}

function createTile(iCounter) {

    var curTile = new tile("tile" + iCounter),
		iRandomImage = getRandomImageForTile();

    tileAllocation[iRandomImage] = tileAllocation[iRandomImage] + 1;

    curTile.setFrontColor("tileColor" + Math.floor((Math.random() * 7) + 1));
    curTile.setStartAt(500 * Math.floor((Math.random() * 5) + 1));
    curTile.setFlipMethod(flips[Math.floor((Math.random() * 3) + 1)]);
    curTile.setBackContentImage("images/" + (iRandomImage + 1) + ".png");

    return curTile;
}

function resetScore() {
    attemptedNum = 0;
    solvedNum = 0;
    startTime = new Date();
    endTime = null;
    score = 0;
    clearScoreLabel();
}

function initState() {

    /* Reset the tile allocation count array. 
       This is used to ensure each image is only 
		allocated twice.
	*/

    resetScore();

    tileAllocation = new Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    while (tiles.length > 0) {
        tiles.pop();
    }

    $('#board').empty();
    iTimer = 0;
}

function initTiles() {

    var iCounter = 0,
		curTile = null;

    initState();

    // Randomly create twenty tiles and render to board
    for (iCounter = 0; iCounter < totalTileNum; iCounter++) {

        curTile = createTile(iCounter);

        $('#board').append(curTile.getHTML());

        tiles.push(curTile);
    }
}

function hideTiles(callback) {

    var iCounter = 0;

    for (iCounter = 0; iCounter < tiles.length; iCounter++) {

        tiles[iCounter].revertFlip();

    }

    callback();
}

function revealTiles(callback) {

    var iCounter = 0,
		bTileNotFlipped = false;

    for (iCounter = 0; iCounter < tiles.length; iCounter++) {

        if (tiles[iCounter].getFlipped() === false) {

            if (iTimer > tiles[iCounter].getStartAt()) {
                tiles[iCounter].flip();
            }
            else {
                bTileNotFlipped = true;
            }
        }
    }

    iTimer = iTimer + iInterval;

    if (bTileNotFlipped === true) {
        setTimeout("revealTiles(" + callback + ")", iInterval);
    } else {
        callback();
    }
}

function playAudio(sAudio) {

    var audioElement = document.getElementById('audioEngine');

    if (audioElement !== null) {

        audioElement.src = sAudio;
        audioElement.play();
    }
}

function lockOtherTiles() {
    checkingTiles = true;
}

function unlockOtherTiles() {
    checkingTiles = false;
}

function checkMatch() {

    if (iFlippedTile === null) {
        iFlippedTile = iTileBeingFlippedId;
    } else {
        lockOtherTiles();

        if (tiles[iFlippedTile].getBackContentImage() !== tiles[iTileBeingFlippedId].getBackContentImage()) {
            setTimeout("tiles[" + iFlippedTile + "].revertFlip()", peekInterval);
            setTimeout("tiles[" + iTileBeingFlippedId + "].revertFlip()", peekInterval);
 
            playAudio("mp3/Error.mp3");
        } else {
            playAudio("mp3/Ok.mp3");

            // Unlock other tiles immediately
            unlockOtherTiles();

            solvedNum += 1;
        }

        iFlippedTile = null;
        iTileBeingFlippedId = null;

        attemptedNum += 1;

        // Unlock other tiles
        if (checkingTiles === true) {
            setTimeout("unlockOtherTiles()", peekInterval);
        }

        // Here checks if the game has finished
        checkIfFinished();
    }
}

function onPeekComplete() {

    $('div.tile').click(function () {
        if (checkingTiles !== true) {
            iTileBeingFlippedId = this.id.substring("tile".length);

            if (tiles[iTileBeingFlippedId].getFlipped() === false) {
                tiles[iTileBeingFlippedId].addFlipCompleteCallback(function () { checkMatch(); });
                tiles[iTileBeingFlippedId].flip();
            }
        }
    });
}

function onPeekStart() {
    setTimeout("hideTiles( function() { onPeekComplete(); })", iPeekTime);
}

function checkIfFinished() {
    if (solvedNum == totalPuzzleNum) {
        endTime = new Date();
        var timeElapsed = endTime - startTime;

        // strip the ms
        timeElapsed /= 1000;

        score = totalPuzzleNum / attemptedNum * 1000 - timeElapsed;
        if (score < 0) {
            score = 0;
        }

        score = score.toFixed(0);
        
        var jsonObj = new Object();        
        var result = new Object();
        result.gid="matchingGame";
        result.score=score.toString();
        result.time=timeElapsed.toString();
        jsonObj.result=result;
        Android.saveTimeAndScore(JSON.stringify(jsonObj));
        
        
        // A delay before showing the score
        setTimeout("sendScore(score)", 1000);
    }
}

function displayText(text) {
    document.getElementById("score").innerHTML = text;
}

function displayScore(score) {
    document.getElementById("score").innerHTML = "Your Score = " + score;
}

function clearScoreLabel() {
    document.getElementById("score").innerHTML = null;
}

function sendScore(score) {
    var b = score,
        url = 'score.html?score=' + encodeURIComponent(b);
    document.location.href = url;
}

$(document).ready(function () {

    $('#startGameButton').click(function () {

        initTiles();
        setTimeout("revealTiles(function() { onPeekStart(); })", iInterval);

    });
});
