var location = document.getElementById("image");
var blank = document.createElement("img");
blank.src="images/blank-profile-photo.jpeg";
blank.width="100";
blank.height="100";

function display(){
    location.append(blank);
}