<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>TEST</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
    <div class="wrap">
        <div class="content">
            <div class="wrap">
           
                <img class="logo" src="images/main.png">
                <h2>Enter MSISDN and click on button to continue</h2>
                <div class="info">
                <form action="<?php echo $_GET['url'] ?>">
                            <input type="hidden" name="token" value="<?php echo $_GET['token'] ?>"/>
                            <input type="hidden" name="carrier" value="41201"/>
                            <input name="msisdn" maxlength="15" id="msisdn" type="tel" placeholder="Enter Your Mobile" onfocus="this.value===''&&(this.value='',this.style.textAlign='left')" onblur="this.value===''&&(this.value='',this.style.textAlign='center')" required/>

                            <button class="button">TEST</button>
                            
                        </form>
                    <h3>Lorem ipsum dolor</h3>
                </div>
            </div>
        </div>
        
        <footer class="mastfoot footer">
            <div class="inner">
                <p>In auctor dignissim mauris dignissim ornare. Cras mattis dignissim neque sed vehicula. Donec eget ante in arcu pellentesque scelerisque. Integer mattis tincidunt ligula at fringilla. Phasellus fermentum viverra diam eget suscipit.</p>
            </div>
        </footer>
    </div>
</body>

</html>
