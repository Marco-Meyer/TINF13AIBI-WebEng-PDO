/*!
 * Sign Up/Login Box v0.0.1 (http://codepen.io/koheishingai/FLvgs)
 * Copyright 2014 Kohei Shingai.
 * Licensed under MIT 
 */

$(function () {
    var user = {},
        flg = {};
    init();
    $('.upload').click(function () {
        if (flg.upd == 0) {
            upd('upload');
            flg.upd = 1
        } else {
            upd('');
            flg.upd = 0
        }
    });
    $('#login').click(function () {
        initub();
        $('#logmsk').fadeIn();
        ub(0)
    });
    $('#logint').click(switchMode);
    
    $("#name").keyup(function () {
        var len = $('#name').val().length;
        if (len > 13 || len == 0) {
            $('#name').css('background', 'rgb(255, 214, 190)');
            blsp();
            if (len != 0) {
                $('#nameal').css('color', 'rgb(255, 57, 19)').text('ID: Too long').fadeIn()
            } else {
                $('#nameal').css('color', 'rgb(255, 57, 19)').text('ID: Null').fadeIn()
            }
            flg.name = 1
        } else {
            $('#name').css('background', 'rgb(255, 255, 255)');
            $('#nameal').css('color', 'rgb(17, 170, 42)').text('ID: Ok').fadeIn();
            flg.name = 0;
            tcheck()
        }
    });
    $("#pass").keyup(function () {
        var len = $('#pass').val().length;
        if (len > 15 || len == 0) {
            $('#pass').css('background', 'rgb(255, 214, 190)');
            blsp();
            if (len != 0) {
                $('#passal').css('color', 'rgb(255, 57, 19)').text('Password: Too long').fadeIn()
            } else {
                $('#passal').css('color', 'rgb(255, 57, 19)').text('Password: Null').fadeIn()
            }
            flg.pass = 1
        } else {
            $('#pass').css('background', 'rgb(255, 255, 255)');
            $('#passal').css('color', 'rgb(17, 170, 42)').text('Password: Ok').fadeIn();
            flg.pass = 0;
            tcheck()
        }
    });

    function tcheck() {
        if (flg.name == 0 && flg.pass == 0) {
            $('#signupb').css('opacity', '1').css('cursor', 'pointer')
        } else {
            blsp()
        }
    }
    $('#signupb').click(function () {
        if (flg.name == 0 && flg.pass == 0 && flg.logt == 1) {
            $('#sumsk').fadeIn();
            $('#name, #pass, #logint, #nameal, #passal, #signupb').css('opacity', '0.2');
            $('#close').fadeIn();
           /* xmlhttp.open('POST','<%=request.getContextPath()%>/pdo/LogInServlet',true);
            xmlhttp.setRequestHeader('UserID','#name');
            xmlhttp.setRequestHeader('UserPW','#pass');
            xmlhttp.send(); */
        } else {
    		var request = new XMLHttpRequest();
    		request.onreadystatechange = function () {
    				if(request.readyState == 4 && request.status == 200) {
    					switchMode();
//						Apprise("Registrierung erfolgreich!", {input: true});
    				}}		
    		request.open("POST", "../RegisterServlet", true);	
    		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    		var name = document.getElementsByName("j_username")[0];
    		var pass = document.getElementsByName("j_password")[0];
    		request.send("UserID=" + name.value + "&UserPW=" + pass.value);
        	return false;
        }
        
    });
    $('#close').click(function () {
        init();
        initub();
        $('#close').hide()
    });

    function init() {
        flg.logt = 0
        switchMode();
    }

    function initub() {
        flg.name = -1;
        flg.pass = -1;
        $('#sumsk').hide();
        $('#nameal').hide();
        $('#passal').hide();
        $('#name, #pass, #logint, #nameal, #passal, #signupb').css('opacity', '1');
        $('#name').css('background', 'rgb(255, 255, 255)');
        $('#pass').css('background', 'rgb(255, 255, 255)');
        $('#signupb').css('opacity', '0.2').css('cursor', 'default');
        $('#name, #pass').val('')
    }

    function upd(button) {
        location.hash = button;
        if (flg.upd == 0) {
            $('#drop').fadeIn()
        } else {
            $('#drop').fadeOut()
        }
    }

	function switchMode() {
        initub();
        if (flg.logt == 0) {
            ub(1);
            flg.logt = 1
        } else {
            ub(0);
            flg.logt = 0
        }
    }
	
    function ub(flg) {
        if (flg == 0) {
            $('#signup').text('Sign up').css('background', '#76ABDB');
            $('#signupb').text('Sign up');
            $('#logint').text('Login as an existing user')
        } else {
            $('#signup').text('Login').css('background', '#FFA622');
            $('#signupb').text('Login');
            $('#logint').text('Sign up as a new user')
        }
    }

    function blsp() {
        $('#signupb').css('opacity', '0.2').css('cursor', 'default')
    }
});