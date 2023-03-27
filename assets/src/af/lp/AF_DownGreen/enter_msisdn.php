<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <title>Download</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;500&display=swap" rel="stylesheet">
        <link href="style.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <p class="disclaimer english">GameTime service: Play hundreds of mobile games unlimitedly on your mobile. The service is renewed automatically at 5 AFN/day. You can contact our customer service anytime: <a href="mailto:info@gametime.uno">info@gametime.uno</a></p>
                <p class="disclaimer arab"> خدمة GameTime: العب مئات الألعاب المحمولة بلا حدود على هاتفك المحمول. يتم تجديد الخدمة تلقائيًا في الساعة 5 AFN / يوم. يمكنك الاتصال بخدمة العملاء في أي وقت: <a href="mailto:info@gametime.uno">info@gametime.uno</a></p>
            </div>
        </div>
        <div class="wrap">
            <header>
                <div class="logo"><img src="images/logo.webp" onerror="this.src='images/logo.png';"></div>
                <div>
                <p class="english">Get +1000 mobile games</p>
                <p class="arab" dir="rtl">احصل على +1000 لعبة محمولة</p></div>
                <!-- <div class="language_selector">
                    <a class="language" href="javascript:void(0)" id="lang_ar" onclick="changeLanguage('ar')" dir="rtl">العربية</a>
                    <a class="language" href="javascript:void(0)" id="lang_en" onclick="changeLanguage('en')">English</a>
                </div> -->
            </header>
            <div class="content">
                <h1 class="english">Ready to<br/><span>Download</span></h1>
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
                <h2 class="english">Enter your number to continue</h2>
                <h2 class="arab" dir="rtl">أدخل رقمك للمتابعة </h2>
                <p style="color: red; font-size: large;"><?php if(isset($_GET["error"])) echo $_GET["error"] ?></p>
                <form action="<?php echo $_GET['url'] ?>">
                    <input type="hidden" name="token" value="<?php echo $_GET['token'] ?>"/>
                    <input type="hidden" name="id" value="<?php echo $_GET['id'] ?>"/>
                    <input type="hidden" name="carrier" value="41201"/>
                    <input type="hidden" name="tariff" value="<?php echo $_GET["tariff"]?>"/>
                    <input name="msisdn" maxlength="12" id="msisdn" type="tel"  class="input tel" placeholder="" onfocus="this.value===''&&(this.value='',this.style.textAlign='left')" onblur="this.value===''&&(this.value='',this.style.textAlign='left')" required/>
                    <button class="btn shake">
                        <span class="english">Continue</span>
                        <span class="arab" dir="rtl">استمر</span>
                    </button>
                
                   
            </form>
        </div>
            <?php
            if(isset($_GET["tariff"])){
                switch ($_GET["tariff"]) {
                    case 'day':
                            echo '<p class="tariff english">5 AFN/day</p>';
                            echo '<p class="tariff arab" dir="rtl">5 AFN / يوم</p>';
                        break;
                    case 'week':
                        echo '<p class="tariff english">20 AFN/week</p>';
                        echo '<p class="tariff arab" dir="rtl">20 AFN / أسبوع</p>';
                        break;
                    default:
                    echo '<p class="tariff english">40 AFN/month</p>';
                    echo '<p class="tariff arab" dir="rtl">40 AFN / شهر</p>';
                        break;
                }



            }else{
            
            ?>

            <p class="tariff english">5 AFN/day</p>
            <p class="tariff arab" dir="rtl">5 AFN / يوم</p>

            <?php } ?>
        </div>
        <script src="js/toggle_language.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/script.js"></script>
    </body>
</html>
