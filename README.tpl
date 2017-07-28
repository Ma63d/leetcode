<p align="center"><img width="300" src="https://raw.githubusercontent.com/Ma63d/leetcode-spider/master/img/site-logo.png"></p>
<p align="center">
    <img src="https://img.shields.io/badge/Solved/Total(Locked)-{{solved}}/{{total}}({{locked}})-green.svg?style=flat-square" alt="">
    <img src="https://img.shields.io/badge/Hard-{{hard}}-blue.svg?style=flat-square" alt="">
    <img src="https://img.shields.io/badge/Medium-{{medium}}-blue.svg?style=flat-square" alt="">
    <img src="https://img.shields.io/badge/Easy-{{easy}}-blue.svg?style=flat-square" alt="">
</p>
<h3 align="center">My leetcode solutions</h3>

<p align="center">
    <b>Language: {{language}}</b>
    <br>
    <b>Last updated: {{time}}</b>
    <br><br>
</p>
<!--请保留下面这行信息，让更多用户了解到这个小爬虫，衷心感谢您的支持-->
<p align="center">The source code was fetched by the tool <a href="https://github.com/Ma63d/leetcode-spider">leetcode-spider</a>.</p>

<!--为了居中，只能直接上 table 元素了-->
<table style="display:table; text-align:center">
    <tr>
        <th>#</th>
        <th>Problems</th>
        <th>Solutions</th>
        <th>Difficulty</th>
    </tr>
    {{#solutions}}
    <tr>
        <td>{{id}}</td>
        <td><a href="https://leetcode.com/problems/{{title}}/">{{title}}</a></td>
        <td>{{{solutionLinks}}}</td>
        <td>{{difficulty}}</td>
    </tr>
    {{/solutions}}
</table>
