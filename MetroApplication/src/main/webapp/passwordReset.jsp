<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>password-reset.jsp</title>
<link rel="icon" href="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar sticky-top bg-#00ff99">
             
             <div class="container-fluid">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo" style="height: 80px; width: 160px;">
                <a class="navbar-brand" href="#">Sticky top</a>
            </div>
</nav>
<center>
<div class="SugnInCard">
 <div class="card border-info mb-3" style="max-width: 28rem;">
    <div class="card-header"><b>Password-reset</b></div>
    <div class="card-body"><span id="info"></span>
      <h5 class="card-title"> Provide Required Info</h5>
      <span style="color: red;">${passerror}</span>
      <form action="onresetpassword" method="post" onclick="form()">
      
        
        <div class="mb-3">
          <label for="emailid" class="form-label" style="margin-right: 280px;">Email address</label><br><span id="validemail"></span>
          <input type="email" class="form-control" name="emailid" id="emailid" onblur="forEmailvalidation()" readonly="readonly" value="${email}">
          <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        
        <div class="mb-3">
          <label for="password" class="form-label" style="margin-right: 290px;">Password</label><br><span id="forPassword"></span>
          <input type="password" class="form-control" id="password" name="password" onblur="passwordvalidation()">
        </div>
        
        <div class="mb-3">
          <label for="conformpassword" class="form-label" style="margin-right: 290px;">Conform-Password</label><br><span id="forconformPassword"></span>
          <input type="password" class="form-control" id="conformpassword" name="conformpassword" onblur="conformpasswordvalidation()">
        </div>
        
        <button type="submit" id="button"  class="btn btn-primary">Submit</button>
      </form>
    
    </div>
  </div><br><br><br><br>
</div>
</center>


<!-- for footer -->
<nav class="navbar sticky-bottom bg-body-tertiary">
    <div class="container-fluid">
        <p style="margin-left: 50px;"><b>Follow on </b>
            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAD30lEQVR4AayShW4cMRCGLQgzHArKDK9xor5KnyDMSZmZmZmZRWWuKMy8e3y7U8/KvXG6PlR+6dM3Wtv/tElYulnzHXI918HnvQZ7PNfgGfdvz1XQEJzFtz14B++y+crCO+D2XoG97ssw475swhwuGWSOK26T3zX24luWbZbehTxe1uS+YOiuCzGwOB+3mA2yAvcFU8cO7Mrsf30R3Lz4nfMcL+eglZyNkm3QGXZhJ0snzrOw3nE61uc4zQs4wmKOxC3PaIszZA4/I2On6zSsY8ni4P9Kx6loX/WJMCCOk5G47dCZ+r79HLtxR8LfueN45F318TDEORYiW4TJHBcvbf8QhT/TJoRiJkQME2bCJvRpJnwaM8TbuX24Q/k3wS82VR0JwRwOB8nSjF5xJgRvhgxIEtEj3kngLibHcQzc1YdDetWhICSj8iD5UW8MUsX+PoBGdNzJ/qXqQHBv5f4AVHCEBX4yp1LMG26EIJ2I+2hpFn18J8OsuQi5lXv9MxV7/ZAul35HIY0k7cCduJtV7tN95bt0sNgdt5g1sjR/GrX/+E9+j8DyI35xV7eh6q/cpftY2Q5tDwfSoVxYj5jwf5Yf4qV0j+bknXtY2bbZZxxIh9KtlkERfjaD52QFcgdSvl17xkq3zP4u3TwDSAlZAZ2pgmeZgrtZ6aZpraRrGpR0kuVZFTpXv1eBu1lpx5RW3DEFFu1kmWzSM21AiehC04wWc/uUxorbpn4XtU6CiuLWKcvZ5HVPxN7ZQkZwNytqnnxW1DwBSGETWSabnPsSkjuV4G5W2DC+hwPJyCZdL/22ngLJYt7DihonfAW1Y2BRR5bJJhtvaeL9OFoJ7mZrGiC3sHb8b6vlcdswFATRL2ZCDagAX12H+3DOOWe7A8d2fFQZlsRMXpzu6z8kVnGdPcDgDbRJ5InP/nFB3lFOTMlck1TVuW8gD8wzcRO3FeQfFvfeQUbeQU5M2K0yOGBJXlVjcmaO1HFTsernecPZTd/c3ZQ0CeTM7M+S3L0MNWbpT/a94abql7ebXDrburidECiZa5LsspZUZO+kzNI2Z31r9JPsmlx7M2namzHZG7J1vaQkp6qBff09csYN3FKS6jt5w1mPA2stos8sCb/b6zFzIPMcduOG+kzORjpurUaBtRKRuRwSsz8LqnpWQuaoV8MAu9V3VF/MG9Zi2DQXAxrwUlhSENeZA7aWwyY/+bc1tkKu/hOXxkLwZswHVLlTUlINNW0mjFnswC71W+FtGLOd+9ps+7k2qw/MtEmSrlNZB+c6z5jBrPo3nZNjzXQm1FTrjgSp6dYDakr3oFd9U+9y1lO9tTZT6gAAAABJRU5ErkJggg==" alt="">
            <img alt="linkedinlogo" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAB20lEQVRYhWP8//8/w0ACpgG1nYGBgQXGaNh106Jx160lDAwMyjS28269m1pMg5v6CQYGBgZGWBQwlmy+QwfL4Y743+OrwsCAGgX0shzFLhZcKjzURRnSLRUYGBgYGGYef8Cw4+ZrmrgEqwM81EUZtqdawPkBOhIMnrNP0MQRWHMBzOeExGjmAHoCrA6YefwBUWLUAFjTwI6brxk8Z58YuEQIcwSplioIcjKIcLMxvPn6i+HJxx8Mf/4RLuZxOuB/jy8Kn7FkM4b4gbtvGTxnn2Aod1JhyLFWZBDhZoPL/fj9l2HFhWcMlduuM7z4/JN0BxADeNiYGXanWzDYKApjyHGwMjMkmMoyWMgLMlhOOszw4ccfrGZQlAtMZAWwWo4MNMR4GLKtFXHKUy0bvvn6i+HBu28MX35i+jRETxKnPoqigIGBgeHPv38MqasuMiw484SBgYGBQYCDhWF9oimDg7IIXI2OJC9O/RSHwJSjD+CWMzAwMHz48Yehdc9tFDUsTLitodgBK88/xRC78+Yr0fopdgC2LPbh+2/6OeDB+++YDsCR5WjiAErBqANGHYDcLKdrF+l/jy8jA8MgCAFkB9ylo71wu+AOqHdTi6GTI+7uz7SMgHEYR3zvGABAiZoIrctOXgAAAABJRU5ErkJggg==">
            <img alt="instalogo" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABwAAAAcCAMAAABF0y+mAAABWVBMVEVyHVFHcEx0Fvp8Fv1yFP1/FfyLCOyfBOmtAeS7AuDHAd3UANjZAs7rD6xyFvzjANTqAMHoA7l2F/yPFfx8GPmfD/zFF/XVWujoZuLyZt3pRt/yGdHyA8j1AKTViPj/9Pr////8g9f9A7r3DZz5vO794Pf+ruj9B6uzFPv7JLv+AJr+BI/+YMP/1vD+AIThG+n9GZn/vd3/YZz+AXP+GoT/r8r+AmT/b5z+HHH+I3f+G2P/ur7+FFD+Klb+fYv/wcr+LUf+LWX+AFn+Nzr+Ohz+RT7+inP+Si7/ztD+TxL/zbv+Wy//9fH+WgL+c1X+ZyX+PUv+Bzv+VXD+cxr/6eL+aQT+eAX+nDj+gwD+gxH+fSL+rYn+jwD+iwL+XhX/3rn/1bH9ZR/+lwP+nwH+xHH8ZC3+qAH+sAD+wAP+x1P+zGb+pl79mQn+uAD9J3T+ygD9O1n8pRL9twuaEkMNAAAAc3RSTlMBAF3G///////////GW9j//9nY/1r///////////7//////8b/////////////////////////////////////////////////////////////////////////////////xf///1v////////Y/9j/2VzGSus+GgAAAeNJREFUeAFFjEWiU0EQRc/tqu74V9wZ4TBiB6wG3wpzVoQ7zHCXeELypHH+KVchJAESaEs0IUv0Zv+7fwLgSAOk9ZFghcnfDw4AAg18cyhWCKNVob9NCZjQLWVrEGhJbJGDoCBpMwCrJTETAKBWgdeRGb4dmJW56PdI/KU1K4X15N+AFsW0+3/WVm7Pa0Pmu4Fh7HcbRIjMIhr3FItUGAH4SNZKjK32YjKpK3Iv0yUY0b8g0Vs0oK+8wbeyMBAQwVeo44R1z7XWq6rqpn5jiTmAeQO3iceg9zkYzKvc71iEmMFbqCJJ4tDcKFrLjX5D/MEdq8GpIUUgd/tgGboTgiUDPDZ44SXNpr0gWRcAgqEmEPJRNVPOxYaOth0oAHdCxWoOzslH+RCvlafYMgFUHvAIHoCjz16io80BrH/j0AAcJ9KWKkhn5sRyGjsDtr/sqyrsWNO1cW9/cDNLZgHLSzVvn+wMq9qbKKwy7TiIaKTW56pzW6Oa+N1OKEQdvvl2RyOE4DEOZurd1cHNeab27tyjOPfhFlucXP04ovF97B6jTOzdJwFLaNAff7N6c8incH1VpiSR67q2VgjzUU7JgbMTiQtFKmgAsCAuczlflmVZn7iGBFc1awB/p4tqUS3LDb8OPwBrSrZIO/KHZwAAAABJRU5ErkJggg==">
            <img alt="twiterlogo" style="border-radius: 30px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAMAAACfWMssAAAAV1BMVEX///8dofIAmvEAnPH2+/4GnvI0p/O22vq93vre7/3v+P7M5vvW6vwAmPHs9v6m0/mZzfiHxfdzvfbk8v1Bq/NpufUAlfGOyPcAkfBRsPR+wfZdtPTH4/udz3kPAAABLklEQVRIie2U2ZaDIAxAScLiVnHBOm39/++c0toptAZ65nHG+4bmSkwgQuzs/HuqZvyNZjUi0nBzx5qLWpaXB9IReBQaUUxHyYkTNvEDrWCFiI4Fm9f1fZTNTPBEGdmVjIgAaIN16IF2Xx23ow+kU/tY1pEIB9YT7l6I86qaSFSG9YR91HAq5JsIvOers36dyJ3trD4WxyBUUew5XpPYdXFw+IuXVKbEeqDmhNjzHhB/bq4XAXkRq1RxzIHN9JTyfOtoW6RE+2/ITm+bGc9ot72hzYgCtgurc54oNwuL7NAITHgvD6Wa/8S6l/pQ6rRFxCc218IfFh0li0NO8He3qudYU5hthJA9XodgnCVePhrjbR/eXkU4NXlpZekdoYf0YNjJzVCVTdnmw3Z2/jjfQWEJXwOeKIcAAAAASUVORK5CYII="><br>
            <b style="margin-right: 30px;">Copyright @ 2024, All Right Reserved</b>
          </p>
          <div class="container-fluid" style="margin-left: 30px;">
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
    </div>
  </nav>
  
  <script>
   
  function passwordvalidation() {
	  var passwords= document.getElementById("password").value;
	  var button=document.getElementById("button");
	  if(passwords.length!="" && passwords.length>=5 && passwords.length<=25){
		  document.getElementById("forPassword").innerHTML="";
		  button.removeAttribute("Disabled");
	  }else{
		  document.getElementById("forPassword").innerHTML="<span style='color:red;'>must be 5 to 25 </span>";
		  button.setAttribute("Disabled","");
		  return;
	  }
    }
  
 function conformpasswordvalidation() {
	 var passwords= document.getElementById("password").value;
	 var conpassword=document.getElementById("conformpassword").value;
	 var button=document.getElementById("button");
	 if(conpassword.length!="" && conpassword==passwords){
		 document.getElementById("forconformPassword").innerHTML="";
		  button.removeAttribute("Disabled");
	 }else{
		 document.getElementById("forconformPassword").innerHTML="<span style='color:red;'>password is missmatch </span>";
		  button.setAttribute("Disabled","");
		  return;
	 }
}
 
 function form() {
	 var passwords= document.getElementById("password").value;
	 var conpassword=document.getElementById("conformpassword").value;
	 var button=document.getElementById("button");
	 
	 if( passwords.length!="" && passwords.length>=5 && passwords.length<=25 &&
	   conpassword.length!="" && conpassword==passwords){
		 
		 document.getElementById("info").innerHTML="<span style='color:red'>please fill all the from</span>";
		 button.removeAttribute("Disabled");
	 }else{
		 button.setAttribute("Disbaled","");
         return;
	 }
	 
}
  
  
  
 
  </script>



</body>
</html>