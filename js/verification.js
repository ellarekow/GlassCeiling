function loginValidate() {
    const uNameResult = nameCheck(document.forms["Login Credentials"]["username"].value);
    const pwordResult = nameCheck(document.forms["Login Credentials"]["password"].value);


    getNotification(Boolean(uNameResult), "uname");
    getNotification(Boolean(pwordResult), "pword");

    console.log(Boolean(uNameResult));
    console.log(Boolean(pwordResult));

    if (Boolean(uNameResult) && Boolean(pwordResult)) {
        location.href = "./Home.html"
    }
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

    console.log(uNameResult, " ", emailResult, " ", pwordResult, " ", pwordCResult)

    if (Boolean(uNameResult) && Boolean(pwordResult) && Boolean(emailResult) && Boolean(pwordCResult)) {
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
    if (atSplit.length == 2 && alphaNumCheck(atSplit[0])) {
        periodSplit = atSplit[1].split('.')
        if (periodSplit.length == 2 && alphaNumCheck(periodSplit[0] + periodSplit[1])) {
            return true;
        }
    }
    valCheck = false;
    return false;
}


function getNotification(bool, id) {
    var label = document.getElementById("labelNotify" + id);
    if (label == null) {
        label = document.createElement("LABEL");
        label.id = "labelNotify" + id;
        label.setAttribute('class', 'errorMessage');
    }

    const errors = { pwordc: "<br> Please ensure your passwords match", eml: "<br> Please enter a valid email", uname: "<br> Please enter a valid username", pword: "<br>Please enter a valid password" }
    errors[id]

    label.innerHTML = bool ? "" : errors[id];
    document.getElementById(id).appendChild(label);
}