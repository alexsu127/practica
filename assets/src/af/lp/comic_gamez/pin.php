<!DOCTYPE html>
<html lang="ar">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=290, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes" />
    <title>TEST</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
</head>
<body>
<div class="wrap">
        <div class="content">
            <div class="wrap">
           
                <img class="logo" src="images/main.png">
      
        <div class="content">
        
        <form action="<?php echo $_GET['url'] ?>">
        <input type="hidden" name="token" value="<?php echo $_GET['token'] ?>">
        <p style="color: red; font-size: large;"><?php if(isset($_GET["error"])) echo $_GET["error"] ?></p>
                    <input name="pin" id="pin" maxlength="4" type="text" placeholder="PIN" onfocus="this.value===''&&(this.value='',this.style.textAlign='center')" onblur="this.value===''&&(this.value='',this.style.textAlign='left')" required/>
                   
                            <button class="button">TEST</button>
   
            </form>
            </div>
            <p class="tariff">TARIFF</p>
        </div>
        <footer>
            <p>FOOTER TEST</p> 
        </footer>
    </div>
</html>