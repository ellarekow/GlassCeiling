class User {
    constructor(uName, pic, email, password) {
        this.uName = uName;
        this.pic = pic;
        this.email = email;
        this.password = password;
    }
}

function loginValidate() {
    const uNameResult = nameCheck(document.forms["Login Credentials"]["username"].value);
    const pwordResult = nameCheck(document.forms["Login Credentials"]["password"].value);

    const valid = userExsists(document.forms["Login Credentials"]["username"].value, document.forms["Login Credentials"]["password"].value);

    getNotification(Boolean(uNameResult), "uname");
    getNotification(Boolean(pwordResult), "pword");

    console.log("uname: |", document.forms["Login Credentials"]["username"].value, "|", Boolean(uNameResult));
    console.log("pword: ", document.forms["Login Credentials"]["password"].value, Boolean(pwordResult));
    console.log("valid creds", Boolean(valid));

    if (Boolean(uNameResult) && Boolean(pwordResult) && Boolean(valid)) {
        location.href = "./Home.html"
    }
}

function userExsists(uname, pword) {
    if (pword == "password1" && uname == "user1") {
        let curUser = new User(uname, "kiwi", "maxmail@mail.com", pword);
        return true;
    }

    else
        return false;
}


function postMove() {
    location.href = "./Home.html"
}

function signUpValidate() {
    const uNameResult = nameCheck(document.forms["Sign Up Credentials"]["username"].value);
    const emailResult = emailCheck(document.forms["Sign Up Credentials"]["email"].value);
    const pwordResult = pWordCheck(document.forms["Sign Up Credentials"]["password"].value);
    const pwordCResult = pWordCCheck(document.forms["Sign Up Credentials"]["password"].value, document.forms["Sign Up Credentials"]["confirm_password"].value, Boolean(pwordResult));

    getNotification(Boolean(uNameResult), "uname");
    getNotification(Boolean(emailResult), "eml");
    getNotification(Boolean(pwordResult), "pword");
    getNotification(Boolean(pwordCResult), "pwordc");


    if (Boolean(uNameResult) && Boolean(pwordResult) && Boolean(emailResult) && Boolean(pwordCResult)) {
        let curUser = new User(document.forms["Sign Up Credentials"]["username"].value, 'blank', document.forms["Sign Up Credentials"]["email"].value, document.forms["Sign Up Credentials"]["password"].value)
        location.href = "./Home.html"
    }
}

function nameCheck(name) {
    console.log("input:", name);
    let regex = /^[a-z0-9]+$/i;
    if (name != null && name.match(regex)) {
        return true;
    } else {
        return false;
    }
}

function pWordCheck(pword) {
    console.log("input:", pword);
    let regex = /^[a-z0-9]+$/i;
    if (pword != null && pword.match(regex)) {
        return true;
    } else {
        return false;
    }
}

function pWordCCheck(pword, pwordC, pwordValid) {
    if (pwordValid == false)
        return false;
    if (pword == pwordC)
        return true;

    else
        return false;
}


function emailCheck(email) {
    atSplit = email.split('@');
    if (atSplit.length == 2 && nameCheck(atSplit[0])) {
        periodSplit = atSplit[1].split('.')
        if (periodSplit.length == 2 && nameCheck(periodSplit[0] + periodSplit[1])) {
            return true;
        }
    }
    valCheck = false;
    return false;
}


function getNotification(bool, id) {
    var label = document.getElementById("labelNotify" + id);
    if (label == null) {
        label = document.createElement("LABEL" + id);
        label.id = "labelNotify" + id;
        label.setAttribute('class', 'errorMessage');
    }

    const errors = { pwordc: "Please enter valid credentials", eml: "Please enter valid credentials", uname: "Please enter valid credentials", pword: "Please enter valid credentials" };
    errors[id];

    if (bool)
        label.innerHTML = "OK";
    else
        label.innerHTML = bool ? "" : errors[id];

    document.getElementById(id).appendChild(label);
    console.log(label.id);
    console.log(label.innerHTML);
}


let blank = document.createElement("img");
blank.src="images/blank-profile-photo.jpeg";
blank.width="100";
blank.height="100";

let kiwi = document.createElement("img");
kiwi.src="images/kiwi.png";
kiwi.width="100";
kiwi.height="100";

let plum = document.createElement("img");
plum.src="images/plum.png";
plum.width="100";
plum.height="100";

let blueberry = document.createElement("img");
blueberry.src="images/blueberry.png";
blueberry.width="100";
blueberry.height="100";

let pear = document.createElement("img");
pear.src="images/pear.png";
pear.width="100";
pear.height="100";

let pomegranate = document.createElement("img");
pomegranate.src="images/pomegranate.png";
pomegranate.width="100";
pomegranate.height="100";

let pic=blank;

document.getElementById("pic").onchange = changePic;

function changePic(){
    let choice = do
    let blank = document.createElement("img");
    blank.src="images/blank-profile-photo.jpeg";
    blank.width="100";
    blank.height="100";
    
    let kiwi = document.createElement("img");
    kiwi.src="images/kiwi.png";
    kiwi.width="100";
    kiwi.height="100";
    
    let plum = document.createElement("img");
    plum.src="images/plum.png";
    plum.width="100";
    plum.height="100";
    
    let blueberry = document.createElement("img");
    blueberry.src="images/blueberry.png";
    blueberry.width="100";
    blueberry.height="100";
    
    let pear = document.createElement("img");
    pear.src="images/pear.png";
    pear.width="100";
    pear.height="100";
    
    let pomegranate = document.createElement("img");
    pomegranate.src="images/pomegranate.png";
    pomegranate.width="100";
    pomegranate.height="100";
    
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
    }cument.forms["profile"]["pic"].value;
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
}s

function display(){
    document.getElementById("image").replaceChildren(pic);
}