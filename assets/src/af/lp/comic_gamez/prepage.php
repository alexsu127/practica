<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>TEST</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
</head>

<body>
    <div class="wrap">
        <!-- YOUR CUSTOM CONTENT -->
        <div class="content">
            <img class="logo-pic" src="images/main.png" />

            <div class="swiper-container slider">
                <div class="swiper-wrapper">
                    <!-- Slides -->
                  
                </div>

                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
                <div class="swiper-pagination"></div>
            </div>

            <form action="<?php echo $_GET['url'] ?>">
				<input name="token" type="hidden" value="<?php echo $_GET['token'] ?>"/>
                    <button class="button">
                       Subscribe
                    </button>
               
                   
            </form>
        </div>
         <div>
                    <input type="checkbox" id="subscribe" name="subscribe" value="subscribe">
                    <p for="subscribe">In auctor dignissim mauris dignissim ornare. Cras mattis dignissim neque sed vehicula. Donec eget ante in arcu pellentesque scelerisque. Integer mattis tincidunt ligula at fringilla.</p>

                </div>
        <footer>
            <p>In auctor dignissim mauris dignissim ornare. Cras mattis dignissim neque sed vehicula. Donec eget ante in arcu pellentesque scelerisque. Integer mattis tincidunt ligula at fringilla. </p>
        </footer>
    </div>

    <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">

    <script src="https://unpkg.com/swiper/js/swiper.js"></script>
    <script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

    <!-- LAUNCHING THE POPUP -->
    <script>
        var mySwiper = new Swiper ('.swiper-container', {
            // Optional parameters
            direction: 'horizontal',
            loop: true,
            autoplay: {
            delay: 1000,
        },

            // Navigation arrows
            navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
            },
        })
    </script>
</body>
</html>
 