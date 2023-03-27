
var languageArray = [
    
    {'language': 'en', 'class': 'english', 'buttonId': 'lang_en'}, // THE DEFAULT LANGUAGE IS THE FIRST ELEMENT OF ARRAY

    {'language': 'ar', 'class': 'arab', 'buttonId': 'lang_ar'}, 
];

var defaultLang = (navigator.language || navigator.userLanguage).split('-')[0];
startLanguage();

function changeLanguage(languageIso){

    // console.log(languageIso);
    // EXIST LANGUAGE IN ARRAY, IF NOT, GET THE FIRST ONE
    if(!languageArray.some(e=> e.language == languageIso)){
        languageIso = languageArray[0].language;
    }
    console.log(languageIso);
    
    // HIDE ELEMENTS
    var classes = languageArray.map(e => { 
        return (e.language == languageIso)? '#' + e.buttonId : '.' + e.class;
    }).join(',');

    document.querySelectorAll(classes).forEach((el) => {
        el.classList.add('hidden');
    });

    // SHOW ELEMENTS
    var classes = languageArray.map(e => {
        return (e.language == languageIso)? '.' + e.class : '#' + e.buttonId;
    }).join(',');

    document.querySelectorAll(classes).forEach((el) => {
        el.classList.remove('hidden');
    });

    // PUT IN SESSION
    sessionStorage.setItem('languageIso', languageIso);
}

function startLanguage(){
    var languageValue = sessionStorage.getItem('languageIso');
    if (languageValue === null) {
        sessionStorage.setItem('languageIso', defaultLang);
        changeLanguage(defaultLang);
    } else {
        changeLanguage(languageValue);
    }
}