const textTel = document.getElementById('textTel');

$(function () {
    const date_now = new Date();
    const year = date_now.getFullYear();
    const month = date_now.getMonth()+1 <10 ? "0"+(date_now.getMonth()+1) : (date_now.getMonth()+1);
    const date = date_now.getDate() < 10 ? "0"+date_now.getDate() : date_now.getDate();
    $("#dateInput").attr("max",year+"-"+month+"-"+date);
})


function filter() {
    return filterTel();
}
function filterTel() {
    const tel = textTel.value;
    const p = /^1(3|4|5|6|7|8|9)\d{9}$/;
    if(!p.test(tel)){
        alert("电话号码输入格式错误")
        textTel.focus();
        return false;
    }
    return true;
}