var moreNum = 5;

window.onload = function() {
    $('.areaPost:nth-child(n + ' + (moreNum + 1) + ')').addClass('is_hidden');
}

$(document).on('click', '.buttonMore button', function() {
    $('.areaPost.is_hidden').slice(0, moreNum).removeClass('is_hidden');
    if ($('.areaPost.is_hidden').length == 0) {
        $('.buttonMore button').remove();
    }
});
