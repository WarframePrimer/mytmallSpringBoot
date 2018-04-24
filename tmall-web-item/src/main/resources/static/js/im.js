/*!Name: im.js
 * Date: 2017-2-14 17:14:16 */
define("MOD_ROOT/js/im", function (require, exports, module) {
    var t = require("MOD_ROOT/js/event").Event, i = require("MOD_ROOT/js/core"),
        e = '<a href="#none" class="J-im-button"><b></b>{text}</a>', a = {
            arr: [], ajax: null, rData: null, init: function (t, i) {
                var e = this;
                return e.rData ? void i(e.rData) : (e.arr.push(i), void(e.ajax || (e.ajax = $.ajax({
                    url: "//chat1.jd.com/api/checkChat?",
                    data: {pid: t, returnCharset: "utf-8"},
                    dataType: "jsonp",
                    success: function (t) {
                        e.rData = t, $.each(e.arr, function (i, e) {
                            e(t)
                        })
                    }
                }))))
            }
        }, n = function (t) {
            this.cfg = t.cfg, this.sku = t.cfg.skuid, this.offlineClass = t.offlineClass || "jd-im-offline", this.$el = t.$el || $("<div></div>"), this.trigger = t.trigger || ".J-im-button", this.template = t.template || e, this.debug = t.debug || !1, this.init()
        };
    n.prototype = {
        init: function () {
            this.bindEvent(), this.get()
        }, bindEvent: function () {
            var t = this;
            this.$el.delegate(this.trigger, "click", function () {
                var i = $(this).attr("data-domain");
                t.open(i)
            })
        }, open: function (t, i) {
            i = i || {};
            var e = {pid: this.cfg.skuid};
            $.extend(i, e);
            var a = "//{0}/index.action?".format(t);
            a += $.param(i), open(a, "\u4eac\u4e1c\u549a\u549a\u5728\u7ebf\u5ba2\u670d")
        }, exists: function (t) {
            return t && t.code && (1 == t.code || 2 == t.code || 3 == t.code || 9 == t.code)
        }, get: function () {
            var e = this;
            a.init(this.cfg.skuid, function (a) {
                var n = e.exists(a);
                n && e.set(a), a && !a.code && i.isJd && $("#popbox").remove(), t.fire({type: "onIMReady", exists: n})
            })
        }, set: function (t) {
            var e = t.seller, a = t.code, n = this.$el.attr("data-name") || name,
                s = this.$el.attr("data-name") || name, o = "";
            e && "" != e && (e = e.replace("&qt;", "'").replace("&dt;", '"')), 1 == a && (n = i.isJd ? "\u8054\u7cfb\u4f9b\u5e94\u5546" : "\u8054\u7cfb\u5356\u5bb6", s = i.isJd ? "\u8054\u7cfb\u4f9b\u5e94\u5546" : "\u8054\u7cfb\u5356\u5bb6", o = i.isJd ? "gys-im" : "pop-im"), i.onAttr("ContactJD") && (o = "newjd-im"), 2 == a && (n = "\u7559\u8a00\u54a8\u8be2", o = this.offlineClass, s = i.isJd ? "\u5ba2\u670d\u76ee\u524d\u4e0d\u5728\u7ebf\uff01\u8d2d\u4e70\u4e4b\u524d\uff0c\u5982\u6709\u95ee\u9898\uff0c\u8bf7\u5728\u6b64\u9875\u201c\u5168\u90e8\u8d2d\u4e70\u54a8\u8be2\u201d\u4e2d\u5411\u4eac\u4e1c\u5ba2\u670d\u53d1\u8d77\u54a8\u8be2" : "\u7b2c\u4e09\u65b9\u5356\u5bb6\u5ba2\u670d\u76ee\u524d\u4e0d\u5728\u7ebf\uff0c\u60a8\u53ef\u4ee5\u70b9\u51fb\u6b64\u5904\u7ed9\u7b2c\u4e09\u65b9\u5356\u5bb6\u5546\u5bb6\u7559\u8a00\uff0c\u5e76\u5728\u3010\u6211\u7684\u4eac\u4e1c-\u6d88\u606f\u7cbe\u7075\u3011\u4e2d\u67e5\u770b\u56de\u590d"), 3 != a && 9 != a || (n = "\u7559\u8a00\u54a8\u8be2", o = this.offlineClass, s = i.isJd ? "\u5ba2\u670d\u76ee\u524d\u4e0d\u5728\u7ebf\uff0c\u60a8\u53ef\u4ee5\u70b9\u51fb\u6b64\u5904\u7ed9\u5546\u5bb6\u7559\u8a00\uff0c\u5e76\u5728\u3010\u6211\u7684\u4eac\u4e1c->\u6d88\u606f\u7cbe\u7075\u3011\u4e2d\u67e5\u770b\u56de\u590d" : "\u7b2c\u4e09\u65b9\u5356\u5bb6\u5ba2\u670d\u76ee\u524d\u4e0d\u5728\u7ebf\uff0c\u60a8\u53ef\u4ee5\u70b9\u51fb\u6b64\u5904\u7ed9\u7b2c\u4e09\u65b9\u5356\u5bb6\u5546\u5bb6\u7559\u8a00\uff0c\u5e76\u5728\u3010\u6211\u7684\u4eac\u4e1c-\u6d88\u606f\u7cbe\u7075\u3011\u4e2d\u67e5\u770b\u56de\u590d", a = 3);
            var r = $(this.template.replace("{text}", n)).attr({
                title: s,
                "data-seller": e,
                "data-code": a,
                "data-domain": t.chatDomain
            });
            r.addClass(o), this.$el.html(r)
        }
    }, module.exports = n
});
