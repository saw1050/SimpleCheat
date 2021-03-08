/**
 * 
 * @param {*} key "String"
 * @param {*} value "String"
 * @param {*} options { expire: int, path: "String", models: ["HttpOnly"] }
 */

const setCookie = function(key, value, options) {
    let option = key + '=' + value + ';';
    if (options != null) {
        if (options.expire != null) {
            let life = new Date();
            life.setTime(life.getTime() + options.expire * 1000);
            option += "expires=" + life.toUTCString() + ';';
        }
        if (options.path != null) {
            option += "path=" + options.path + ';';
        }
        if (options.models != null && options.models.length > 0) {
            for (let item in options.models) {
                option += item + ";"
            }
        }
    }
    document.cookie = option;
}

const getCookie = function(key) {
    let arr = document.cookie.match(key + "=.*;?");
    if (arr != null && arr.length > 0)
        return arr[0].replace(key + '=', '').replace(';', '');
    else
        return null;
}

const removeCookie = function(key) {
    setCookie(key, '', { expire: 0 });
}

export {
    setCookie,
    getCookie,
    removeCookie
}