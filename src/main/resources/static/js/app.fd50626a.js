(function(t){function e(e){for(var n,l,i=e[0],s=e[1],c=e[2],p=0,d=[];p<i.length;p++)l=i[p],Object.prototype.hasOwnProperty.call(a,l)&&a[l]&&d.push(a[l][0]),a[l]=0;for(n in s)Object.prototype.hasOwnProperty.call(s,n)&&(t[n]=s[n]);u&&u(e);while(d.length)d.shift()();return r.push.apply(r,c||[]),o()}function o(){for(var t,e=0;e<r.length;e++){for(var o=r[e],n=!0,i=1;i<o.length;i++){var s=o[i];0!==a[s]&&(n=!1)}n&&(r.splice(e--,1),t=l(l.s=o[0]))}return t}var n={},a={app:0},r=[];function l(e){if(n[e])return n[e].exports;var o=n[e]={i:e,l:!1,exports:{}};return t[e].call(o.exports,o,o.exports,l),o.l=!0,o.exports}l.m=t,l.c=n,l.d=function(t,e,o){l.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:o})},l.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},l.t=function(t,e){if(1&e&&(t=l(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var o=Object.create(null);if(l.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)l.d(o,n,function(e){return t[e]}.bind(null,n));return o},l.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return l.d(e,"a",e),e},l.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},l.p="";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],s=i.push.bind(i);i.push=e,i=i.slice();for(var c=0;c<i.length;c++)e(i[c]);var u=s;r.push([0,"chunk-vendors"]),o()})({0:function(t,e,o){t.exports=o("56d7")},3160:function(t,e,o){"use strict";o("39c9")},"39c9":function(t,e,o){},"56d7":function(t,e,o){"use strict";o.r(e);o("e260"),o("e6cf"),o("cca6"),o("a79d");var n=o("a026"),a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{attrs:{id:"app"}},[o("router-view",{attrs:{name:"login"}})],1)},r=[],l={name:"App",components:{}},i=l,s=o("2877"),c=Object(s["a"])(i,a,r,!1,null,null,null),u=c.exports,p=o("8c4f"),d=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("div",{staticClass:"h-100 bg-plum-plate bg-animation"},[o("div",{staticClass:"d-flex h-100 justify-content-center align-items-center"},[o("b-col",{staticClass:"mx-auto app-login-box",attrs:{md:"8"}},[o("div",{staticClass:"app-logo-inverse mx-auto mb-3"}),o("div",{staticClass:"modal-dialog w-100 mx-auto"},[o("div",{staticClass:"modal-content"},[o("div",{staticClass:"modal-body"},[o("div",{staticClass:"h5 modal-title text-center"},[o("h4",{staticClass:"mt-2"},[o("div",[t._v("Welcome back,")]),o("span",[t._v("Please sign in to your account below.")])]),o("br")]),o("b-form-group",{attrs:{id:"exampleInputGroup1","label-for":"exampleInput1"}},[o("b-form-input",{attrs:{id:"exampleInput1",type:"text",required:"",placeholder:"Enter id..."},model:{value:t.loginInfo.id,callback:function(e){t.$set(t.loginInfo,"id",e)},expression:"loginInfo.id"}}),o("br")],1),o("b-form-group",{attrs:{id:"exampleInputGroup2","label-for":"exampleInput2"}},[o("b-form-input",{attrs:{id:"exampleInput2",type:"password",required:"",placeholder:"Enter password..."},model:{value:t.loginInfo.password,callback:function(e){t.$set(t.loginInfo,"password",e)},expression:"loginInfo.password"}}),o("br")],1),o("b-form-checkbox",{attrs:{name:"check",id:"exampleCheck"}},[t._v(" Keep me logged in ")]),o("div",{staticClass:"divider"}),o("h6",{staticClass:"mb-0"},[t._v(" No account? "),o("a",{staticClass:"text-primary",attrs:{href:"javascript:void(0);"}},[t._v("Sign up now")])])],1),o("div",{staticClass:"modal-footer clearfix"},[o("div",{staticClass:"float-left"},[o("a",{staticClass:"btn-lg btn btn-link",attrs:{href:"javascript:void(0);"}},[t._v("Recover Password")])]),o("div",{staticClass:"float-right"},[o("b-button",{attrs:{variant:"primary",size:"lg"},on:{click:t.login}},[t._v("Login to Dashboard")])],1)])])])])],1)])])},f=[],v={data:function(){return{loginInfo:[{id:""},{password:""}]}},methods:{login:function(){var t=this;alert("check!"),this.$axios.get("/api/login").then((function(e){alert("login success"+e.data),t.$router.push("/api/login")})).catch((function(t){console.error("failed login",t)}))}}},b=v,m=Object(s["a"])(b,d,f,!1,null,null,null),h=m.exports,g=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{attrs:{id:"app"}},[o("layout",[o("div",{attrs:{slot:"header"},slot:"header"},[o("h2",[t._v("Sample")])]),o("div",{attrs:{slot:"nav"},slot:"nav"},[o("ul",[o("li",[o("router-link",{attrs:{to:"/board"}},[t._v("BOARD")])],1)])]),o("div",{attrs:{slot:"content"},slot:"content"},[o("router-view")],1),o("p",{attrs:{slot:"footer"},slot:"footer"},[t._v("Footer !")])])],1)},x=[],y=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{attrs:{id:"pagewrap"}},[o("header",[t._t("header")],2),o("nav",[t._t("nav")],2),o("section",{attrs:{id:"content"}},[t._t("content")],2),o("footer",[t._t("footer")],2)])},_=[],w={},C=Object(s["a"])(w,y,_,!1,null,null,null),j=C.exports,O={components:{Layout:j}},I=O,k=(o("3160"),Object(s["a"])(I,g,x,!1,null,null,null)),$=k.exports;n["default"].use(p["a"]);var P=new p["a"]({mode:"history",routes:[{path:"/",name:"",components:{login:h,board:$}}]}),S=o("bc3a"),E=o.n(S),M=o("2f62");n["default"].use(M["a"]);var T=new M["a"].Store({state:{loginInfo:[{id:""},{password:""}]},getters:{},mutations:{}}),q=o("5f5b"),A=o("b1e0");o("f9e3"),o("2dd8");n["default"].use(q["a"]),n["default"].use(A["a"]),n["default"].config.productionTip=!1,n["default"].prototype.$axios=E.a,new n["default"]({router:P,store:T,render:function(t){return t(u)}}).$mount("#app")}});