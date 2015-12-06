(function($) {
    $(function() {
        var imageIndex=0;
        $('.jcarousel').jcarousel({
        });

        $('.jcarousel-control-prev')
            .on('jcarouselcontrol:active', function() {
                $(this).removeClass('inactive');
            })
            .on('jcarouselcontrol:inactive', function() {
                $(this).addClass('inactive');
            })
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel-control-next')
            .on('jcarouselcontrol:active', function() {
                $(this).removeClass('inactive');
            })
            .on('jcarouselcontrol:inactive', function() {
                $(this).addClass('inactive');
            })
            .jcarouselControl({
                target: '+=1'
            });
        window.setInterval(function(){
            var items = $('.jcarousel').jcarousel('items');
            if(imageIndex<items.length){
                $('.jcarousel').jcarousel('scroll', '+=1');
                imageIndex=imageIndex+1;
            }else{
                $('.jcarousel').jcarousel('scroll', 0);
                imageIndex=0;
            }

        }, 5000);
    });
})(jQuery);

