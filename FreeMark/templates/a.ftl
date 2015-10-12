你好 ，这是${username}的第一个freemark程序
------------------------------------
<#if username=="邓林">
我就是彭大神
</#if>------------------------------
<#if radom lt 60>
及格
<#else>
不及格
</#if>
========================================
测试list语句
<#list lst as dizhi >
<b>${dizhi}</b><br/>
</#list>
=======================
<#include "include.txt"/>
=========================
 测试宏指令
 <#macro m1>
 <b>aaaabbbbbbccc</b>
 <a>abcdefg</a>
 </#macro>

<@m1/>
=========================
定义带参数的宏
<#macro m2 a b c >
${a}-----${b}-----${c}
</#macro>

调用宏:
<@m2 "aa" "bb" "cc"/>

<#macro border>
<table border=4 cellcpacing=0 cellpadding=4>
	<tr>
		<td>
		<#nested>
		</td>
	</tr>

</#macro>

<@border>我是一个兵，来自老百姓</@border>
