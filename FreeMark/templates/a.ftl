��� ������${username}�ĵ�һ��freemark����
------------------------------------
<#if username=="����">
�Ҿ��������
</#if>------------------------------
<#if radom lt 60>
����
<#else>
������
</#if>
========================================
����list���
<#list lst as dizhi >
<b>${dizhi}</b><br/>
</#list>
=======================
<#include "include.txt"/>
=========================
 ���Ժ�ָ��
 <#macro m1>
 <b>aaaabbbbbbccc</b>
 <a>abcdefg</a>
 </#macro>

<@m1/>
=========================
����������ĺ�
<#macro m2 a b c >
${a}-----${b}-----${c}
</#macro>

���ú�:
<@m2 "aa" "bb" "cc"/>

<#macro border>
<table border=4 cellcpacing=0 cellpadding=4>
	<tr>
		<td>
		<#nested>
		</td>
	</tr>

</#macro>

<@border>����һ�����������ϰ���</@border>
