
$(document).ready(function() {
    //check if this is user's first time on page
    if(!getCookie('Theme')){
        if (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches) {
            currentTheme = "ON";
        } else {
            currentTheme = "OFF";
        }
    } else {
        currentTheme = getCookie('Theme');
    }
    setTheme(currentTheme);
});

$(".inner-switch").on("click", function () {
    if ($("body").hasClass("dark")) {
        setTheme('OFF');
    } else {
        setTheme('ON');
    }
});

// DARK MODE TOGGLE FUNCTION
function setTheme(theme) {
    if (theme === 'ON') {
        $("body").addClass("dark");
        $(".inner-switch").text("ON");
        setCookie('Theme', 'ON', 999);
    } else {
        $("body").removeClass("dark");
        $(".inner-switch").text("OFF");
        setCookie('Theme', 'OFF', 999);
    }
};

// Xử lí cooking

function getCookie(name) {
    var v = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return v ? v[2] : null;
}

function setCookie(name, value, days) {
    var d = new Date;
    d.setTime(d.getTime() + 24 * 60 * 60 * 1000 * days);
    document.cookie = name + "=" + value + ";path=/;expires=" + d.toGMTString();
}

function deleteCookie(name) {
    setCookie(name, '', -1);
}