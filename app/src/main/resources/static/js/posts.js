var moreNum = 5;

window.onload = function() {
    $('.Area_post:nth-child(n + ' + (moreNum + 1) + ')').addClass('is_hidden');
}

$(document).on('click', '.Button_more button', function() {
    $('.areaPost.is_hidden').slice(0, moreNum).removeClass('is_hidden');
    if ($('.areaPost.is_hidden').length == 0) {
        $('.Button_more').remove();
    }
});
