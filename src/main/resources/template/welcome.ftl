<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    Welcome, ${name} !

    Today is ${date} !
    <div>
        <h3>price list</h3>

        <table border="1">
            <thead>
            <td>#</td>
            <td>Title</td>
            <td>Price</td>
            <td>PriceRounded</td>
            </thead>
            <tbody>
            <#list items as row>
            <tr>
                <td>${row.id}</td>
                <td>${row.name}</td>
                <td>${row.price}</td>
                <td>${row.getPriceRounded()}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</body>
</html>