<#macro menu>
<aside class="main-sidebar">
    <section class="sidebar">
        <ul class="sidebar-menu">
            <li class="header">主导航</li>
            </br>
                <ul class="">
                    <li>
                        <a target="navTab"   fresh="false" href="/admin/users">
                            <i class="fa fa-inbox"></i> <span>用户管理</span>
                        </a>
                    </li>
                </ul>
                <ul class="">
                    <li>
                        <a target="navTab"   fresh="false" href="/admin/questions">
                            <i class="fa fa-inbox"></i> <span>问题管理</span>
                        </a>
                    </li>
                </ul>
        </ul>
    </section>
</aside>
</#macro>

<#macro footer>
</#macro>
<#macro setting>
</#macro>


<#macro header>
<header class="main-header">
    <a href="index2.html" class="logo">
        <span class="logo-mini"><b>Campusqa</b></span>
        <span class="logo-lg"><b>Campusqa</b></span>
    </a>
    <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">切换导航</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="adminlte/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> <span
                            class="hidden-xs">校园自动应答平台管理后台</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <img src="adminlte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                admin
                            </p>
                        </li>
                        <li class="user-footer">
                            <div class="">
                                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                <a href="/admin/logout" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>
</#macro>


<#macro style>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="shortcut icon" type="image/x-icon" href="adminlte/dist/img/favicon.ico">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="adminlte/dist/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="adminlte/dist/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="adminlte/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
   folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="adminlte/dist/css/skins/_all-skins.min.css"
<!-- 以上为公共css -->

<!-- daterange picker -->
<link rel="stylesheet" href="adminlte/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="adminlte/plugins/datepicker/datepicker3.css">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="adminlte/plugins/iCheck/all.css">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet" href="adminlte/plugins/colorpicker/bootstrap-colorpicker.min.css">
<!-- Bootstrap time Picker -->
<link rel="stylesheet" href="adminlte/plugins/timepicker/bootstrap-timepicker.min.css">
<!-- Select2 -->
<link rel="stylesheet" href="adminlte/plugins/select2/select2.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="adminlte/plugins/iCheck/flat/blue.css">

<!-- fullCalendar 2.2.5-->
<link rel="stylesheet" href="adminlte/plugins/fullcalendar/fullcalendar.min.css">
<link rel="stylesheet" href="adminlte/plugins/fullcalendar/fullcalendar.print.css" media="print">

<!-- Ion Slider -->
<link rel="stylesheet" href="adminlte/plugins/ionslider/ion.rangeSlider.css">
<!-- ion slider Nice -->
<link rel="stylesheet" href="adminlte/plugins/ionslider/ion.rangeSlider.skinNice.css">
<!-- bootstrap slider -->
<link rel="stylesheet" href="adminlte/plugins/bootstrap-slider/slider.css">

<!-- Morris chart -->
<link rel="stylesheet" href="adminlte/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet" href="adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.css">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<script>
    function onClickCheckbox(clickName, target) {
        var status = false;
        if (document.getElementById(clickName).checked) {
            status = true;
        }
        var list = document.getElementsByName(target);
        for (var i = 0; i < list.length; i++) {
            list[i].checked = status;
        }
    }

    function iFrameHeight() {
        var ifm = document.getElementById("content");
        var subWeb = document.frames ? document.frames["content"].document : ifm.contentDocument;
        if (ifm != null && subWeb != null) {
            ifm.height = subWeb.body.scrollHeight;
        }
    }
</script>
</#macro>

<#macro jsFile>
<!-- jQuery 2.2.3 -->
<script src="adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="adminlte/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="adminlte/plugins/fastclick/fastclick.js"></script>
<!-- Slimscroll -->
<script src="adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- AdminLTE App -->
<script src="adminlte/dist/js/app.js"></script>
<!-- 以上JS为页面必须 -->

<!-- jQuery UI 1.11.4 -->
<script src="adminlte/plugins/jQueryUI/jquery-ui.min.js"></script>
<!-- Morris.js charts -->
<script src="adminlte/plugins/raphael/raphael.min.js"></script>
<script src="adminlte/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="adminlte/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="adminlte/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="adminlte/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="adminlte/plugins/moment/moment.min.js"></script>
<script src="adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="adminlte/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="adminlte/plugins/chartjs/Chart.min.js"></script>
<!-- FLOT CHARTS -->
<script src="adminlte/plugins/flot/jquery.flot.min.js"></script>
<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
<script src="adminlte/plugins/flot/jquery.flot.resize.min.js"></script>
<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
<script src="adminlte/plugins/flot/jquery.flot.pie.min.js"></script>
<!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
<script src="adminlte/plugins/flot/jquery.flot.categories.min.js"></script>
<!-- iCheck -->
<script src="adminlte/plugins/iCheck/icheck.min.js"></script>
<!-- Select2 -->
<script src="adminlte/plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="adminlte/plugins/input-mask/jquery.inputmask.js"></script>
<script src="adminlte/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="adminlte/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="adminlte/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="adminlte/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<!-- bootstrap color picker -->
<script src="adminlte/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="adminlte/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- Ion Slider -->
<script src="adminlte/plugins/ionslider/ion.rangeSlider.min.js"></script>
<!-- Bootstrap slider -->
<script src="adminlte/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<!-- DataTables -->
<script src="adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
    var list_ajax;
    var date_ajax;
    var search_ajax;
    //当你需要多条件查询，你可以调用此方法，动态修改参数传给服务器
    //查询添加的时候需要重写该方法，每个页面查询参数不一样，请参考user/list
    window.reloadTable = function (oTable, datePremise, premise) {
//        var date = $(datePremise).val();
//        var search = $(premise).val();
//        var param = {
//            "date": date,
//            "search": search
//        };
//        oTable.settings()[0].ajax.data = param;
        oTable.ajax.reload();
    }
</script>
</#macro>
