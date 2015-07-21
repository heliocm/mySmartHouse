$(document).ready(function(){

    //Bootstrap Material Initializer
    $.material.init();

    //Fullpage Initializer
    /*$("[data-fullpage]").fullpage({scrollBar: true,
        autoScrolling:false,
        fitToSection:false,
        paddingTop:"75px",
        slidesNavigation: true
    });*/

    //Bootstrap Tooltip Initializer
    $("[data-toggle=tooltip]").tooltip();

    $("body").scrollspy({target:"#header-menu"});

    $(".navbar a").smoothScroll({
        offset:-60
    });

    $("#contato form").submit(function(){
        var form = $(this);

        $("[type=submit]",form).button('loading');
    });
});
