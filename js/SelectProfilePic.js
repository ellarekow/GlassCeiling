
let blank = document.createElement("img");
blank.src="images/blank-profile-photo.jpeg";
blank.width="200";
blank.height="200";

let kiwi = document.createElement("img");
kiwi.src="images/kiwi.png";
kiwi.width="200";
kiwi.height="200";

let plum = document.createElement("img");
plum.src="images/plum.png";
plum.width="200";
plum.height="200";

let blueberry = document.createElement("img");
blueberry.src="images/blueberry.png";
blueberry.width="200";
blueberry.height="200";

let pear = document.createElement("img");
pear.src="images/pear.png";
pear.width="200";
pear.height="200";

let pomegranate = document.createElement("img");
pomegranate.src="images/pomegranate.png";
pomegranate.width="200";
pomegranate.height="200";

let pic=blank;

document.getElementById("pic").onchange = changePic;

function changePic(){
    let choice = document.forms["profile"]["pic"].value;
    if(choice == "blank"){
       pic=blank;
    }else if(choice== "blueberry"){
        pic=blueberry;
    }else if(choice== "pear"){
        pic=pear;
    }else if(choice== "kiwi"){
        pic=kiwi;
    }else if(choice== "pomegranate"){
        pic=pomegranate;
    }else{
        pic=plum;
    }
    display();
}

function display(){
    document.getElementById("image").replaceChildren(pic);
}