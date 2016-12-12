/**
 * Created by Mariusz on 2016-12-12.
 */
$(document).mousemove(function(e){
    $("#progress").css({left:e.pageX + 20, top:e.pageY});
});
