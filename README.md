# DaemonService
进程 保活：根据系统漏洞，进行灰色保活，创建一个没有notification的前台进程，相当于后台进程（目前像QQ，微信，陌陌，支付宝都是依赖于这个漏洞进行的app保活）<br> 
所说的漏洞请看下图<br>
------------------------------------------------------------
![image](https://github.com/HadisNZL/DaemonService/blob/master/screenshot/daemonservice.png)<br>
红框框里面的翻译一下：<br>
大意：“调用者不提供一个通知图标是不正确的，但这是可以通过的，因此对于那些肮脏的应用，我们将会创建一个明确的通知，并将其归咎于该应用。”
哈哈 害怕不？人家都解释了，这个漏洞相信会在不久就进行封堵了。。。。😂
ps：所有的进程保活都是相对的，如果想达到理想化状态，还是建议大家老老实实的对app进行优化吧！扑哧
