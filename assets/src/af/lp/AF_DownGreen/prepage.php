<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Download</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;500&display=swap" rel="stylesheet">
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
</head>

<body>
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <p class="disclaimer english">GameTime service: Play hundreds of mobile games unlimitedly on your mobile. The service is renewed automatically at 5 AFN/daily, 20 AFN/weekly, or 40AFN/monthly. You can contact our customer service anytime:<a href="mailto:info@gametime.uno">info@gametime.uno</a></p>
            <p class="disclaimer arab"> خدمة GameTime: العب مئات الألعاب المحمولة بلا حدود على هاتفك المحمول. يتم تجديد الخدمة تلقائيًا في الساعة 5 AFN / يوم. يمكنك الاتصال بخدمة العملاء في أي وقت: <a href="mailto:info@gametime.uno">info@gametime.uno</a></p>
        </div>
    </div>
      <!-- The Modal -->
      <div id="ModalButton" class="modal">
        <!-- modal to the button -->
        <div class="modal-content" id= "modal-button">
            <span id="closeId" class="close" onclick="close()">&times;</span>
            <p class="disclaimer english">Please tick the box to continue</p>
        </div>
    </div>
    <div class="wrap">
        <header>
            <div class="logo"><img src="images/logo.webp" onerror="this.src='images/logo.png';"></div>
            <div>
                <p class="english">Get +1000 mobile games</p>
                <p class="arab" dir="rtl">احصل على +1000 لعبة محمولة</p>
            </div>
            <!-- <div class="language_selector">
                <a class="language" href="javascript:void(0)" id="lang_ar" onclick="changeLanguage('ar')" dir="rtl">العربية</a>
                <a class="language" href="javascript:void(0)" id="lang_en" onclick="changeLanguage('en')">English</a>
            </div> -->
        </header>
        <div class="content">
            <h1 class="english">Ready to<br /><span>Download</span></h1>
            <h1 class="arab" dir="rtl">مستعد ل<br /> <span>تحميل</span></h1>
            <div class="success-wrapper">
                <div class="success-checkmark">
                    <div class="check-icon">
                        <span class="icon-line line-tip"></span>
                        <span class="icon-line line-long"></span>
                        <div class="icon-circle"></div>
                        <div class="icon-fix"></div>
                    </div>
                </div>
            </div>
            <h2 class="english">Click below to continue</h2>
            <h2 class="arab" dir="rtl">انقر أدناه للمتابعة </h2>
            <form action="<?php echo $_GET['url'] ?>">
            <input name="cid" type="hidden" value="<?php echo $_GET['cid'] ?>" />
            <input type="hidden" name="msisdn" value="<?php echo $_GET['msisdn'] ?>" />
                <button class="btn shake">
                    <span class="english" onclick="popUp()">Continue</span>
                    <span class="arab" dir="rtl">استمر</span>
                </button>
                <div class="check_container">

                    <div class="subscribe_text" for="subscribe">
                        <input type="checkbox" id="subscribe" name="subscribe" value="subscribe" required checked>
                        <label for="subscribe">
                            <span></span>
                            <p class="english">By clicking continue, you agree to the <a href="javascript:void()" id="Terms">terms and conditions</a></p>
                            <p class="arab" dir="rtl"> بالنقر فوق "متابعة" ، فإنك توافق على <a href="javascript:void()" id="Terms_ar"> بنود وشروط </a> الاستخدام </p>
                        </label>
                    </div>
                </div>

                <p class="tariff" id="day">
                    <span class="english">5 AFN/day</span>
                    <span class="arab" dir="rtl">25 دج / اليوم</span>
                </p>
                <p class="tariff" id="week">
                    <span class="english">20 AFN/week</span>
                    <span class="arab" dir="rtl">100 دينار / أسبوع</span>
                </p>
                <p class="tariff" id="month">
                    <span class="english">40 AFN/month</span>
                    <span class="arab" dir="rtl">100 دينار / أسبوع</span>
                </p>

                <div class="radio-wrapper">

                    <div class="radio-option">
                        <input type="radio" id="daily" name="tariff" value="day" checked onclick="refresh()">
                        <label for="daily">
                            <span class="english">Daily tariff</span>
                            <span class="arab" dir="rtl">التعريفة اليومية</span>
                        </label>
                    </div>

                    <div class="radio-option">
                        <input type="radio" id="weekly" name="tariff" value="week" onclick="refresh()">
                        <label for="weekly">
                            <span class="english">Weekly tariff</span>
                            <span class="arab" dir="rtl">التعريفة الأسبوعية</span>
                        </label>
                    </div>

                    <div class="radio-option">
                        <input type="radio" id="monthly" name="tariff" value="month" onclick="refresh()">
                        <label for="monthly">
                            <span class="english">Monthly tariff</span>
                            <span class="arab" dir="rtl">التعريفة الأسبوعية</span>
                        </label>
                    </div>

                </div>
            </form>
            <footer>

            </footer>
        </div>

    </div>
    <script src="js/toggle_language.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="js/script.js"></script>
    <script>
        function refresh() {
            if ($('#daily').is(':checked')) {
                $('#week').addClass("hidden");
                $('#month').addClass("hidden");
                $('#day').removeClass("hidden");
            }
            if ($('#weekly').is(':checked')) {
                $('#day').addClass("hidden");
                $('#month').addClass("hidden");
                $('#week').removeClass("hidden");

            }
            if ($('#monthly').is(':checked')) {
                $('#day').addClass("hidden");
                $('#week').addClass("hidden");
                $('#month').removeClass("hidden");
            }
        }

        $(document).ready(function() {
            refresh();
        });
    </script>
</body>

</html>