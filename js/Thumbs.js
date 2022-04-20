var up=0;
var down=0;
var upClicked= false;
var downClicked=false;

let blankUp = document.createElement("img");
blankUp.src="images/up.png";
blankUp.width="50";
blankUp.height="50";

let blankDown = document.createElement("img");
blankDown.src="images/down.png";
blankDown.width="50";
blankDown.height="50";

let greenUp = document.createElement("img");
greenUp.src="images/green.png";
greenUp.width="50";
greenUp.height="50";

let redDown = document.createElement("img");
redDown.src="images/red.png";
redDown.width="50";
redDown.height="50";

let leftpic=blankUp;
let rightpic=blankDown;

function display(){
    document.getElementById("thumbsup").replaceChildren(leftpic);
    document.getElementById("thumbsdown").replaceChildren(rightpic);
    document.getElementById("upVotes").replaceChildren(up);
    document.getElementById("downVotes").replaceChildren(down);
}

function upVote(){
    if(upClicked){
        up=up-1;
        upClicked=false;
        leftpic=blankUp;
        display();
    }else{
        if(downClicked){
            down=down-1;
            downClicked=false;
            rightpic=blankDown;
        }
        up=up+1;
        upClicked=true;
        leftpic=greenUp;
        display();
    }
}

function downVote(){
    if(downClicked){
        down=down-1;
        downClicked=false;
        rightpic=blankDown;
        display();
    }else{
        if(upClicked){
            up=up-1;
            upClicked=false;
            leftpic=blankUp;
        }
        down=down+1;
        downClicked=true;
        rightpic=redDown;
        display();
    }
}
