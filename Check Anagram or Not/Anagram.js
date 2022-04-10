const prompt = require('prompt-sync')();
const words = prompt('Enter your words using comma seperator ? ');
var inputWords = words.split(',').map(function(item) {
    return item;
});
if (inputWords.length > 2)
{
    console.log(" Invalid Input ");
}else{
    var word1 = inputWords[0].split('');
    var word2 = inputWords[1].split('');
    if (checkAnagram(word1, word2)) {
        console.log("The two words are" +
        " anagram");
    }else{
        console.log("The two words are not" +
        " anagram");
    }
}

function checkAnagram(str1,str2)
{
    //case 1 if lenth is not same then both words are not anagram
    let n1 = str1.length;
    let n2 = str2.length;
    if (n1 != n2)
        return false;
   
    // Sort both strings
    str1=sortString(str1);
    str2=sortString(str2);
   
    // Compare sorted strings both words havening same lettrns or not
    for (let i = 0; i < n1; i++)
        if (str1[i] != str2[i])
            return false;
   
    return true;
}

function sortString(str) {
    var i = 0;
    var j;
    while (i < str.length) {
        j = i + 1;
        while (j < str.length) {
            if (str[j] < str[i]) {
                var tempStr = str[i];
                str[i] = str[j];
                str[j] = tempStr;
            }
        j++;
        }
    i++;
    }
    return str;
}