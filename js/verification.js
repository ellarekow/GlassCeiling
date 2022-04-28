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

    // console.log("uname: |", document.forms["Login Credentials"]["username"].value, "|", Boolean(uNameResult));
    // console.log("pword: ", document.forms["Login Credentials"]["password"].value, Boolean(pwordResult));
    // console.log("valid creds", Boolean(valid));

    if (Boolean(uNameResult) && Boolean(pwordResult) && Boolean(valid)) {
        location.href = "./Home.html"
    }
}


function userExsists(uname, pword) {
    const file = fetch('users.txt').then(function (info) {
        return info.text()
    });

    var reader = new FileReader()

    reader.onload = function (evt) {
        var lines = evt.result.split('\n');
        for (var i = 0; i < lines.length; i++) {
            console.log(lines[i]);
            userinfo = lines[i].split(',');
            for (var j = 0; j < userinfo.length; j++) {
                console.log("info: ", userinfo[j], "\n");
            }
        }
    }
    reader.readAsText([""], file);





    if (pword == "password1" && uname == "user1")
        return true;

    else
        false;
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
        let user = new User(document.forms["Sign Up Credentials"]["username"].value, 'blank', document.forms["Sign Up Credentials"]["email"].value, document.forms["Sign Up Credentials"]["password"].value)
        location.href = "./Home.html"
    }
}

function nameCheck(name) {
    // console.log("input:", name);
    let regex = /^[a-z0-9]+$/i;
    if (name != null && name.match(regex)) {
        return true;
    } else {
        return false;
    }
}

function pWordCheck(pword) {
    // console.log("input:", pword);
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
    // console.log(label.id);
    // console.log(label.innerHTML);
}