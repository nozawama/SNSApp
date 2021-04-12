var moreNum = 5;

window.onload = function() {
    var list_post = document.getElementsByClassName("areaPost");
    for(var i = moreNum; i < list_post.length; i++) {
        list_post.item(i).classList.add("is_hidden");
    }
    if (list_post.length <= moreNum) {
        document.getElementById("buttonMore").remove();
    }
}

document.getElementById("buttonMore").onclick = function () {
    var list_hidden = document.getElementsByClassName("is_hidden");
    for(var i = 0; i < moreNum; i++) {
        if (list_hidden.length > 0) list_hidden.item(0).classList.remove("is_hidden");
        else break;
    }
    if (list_hidden.length == 0) {
        document.getElementById("buttonMore").remove();
    }
}
