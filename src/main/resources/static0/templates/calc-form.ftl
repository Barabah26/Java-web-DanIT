<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <p>user_id: ${user_id}</p>

    <form method="post">
        <input type="text" name="x"><br>
        <select name="op">
            <option>add</option>
            <option>sub</option>
            <option>mul</option>
            <option>div</option>
        </select>
        <input type="text" name="y"><br>
        <button>calculate!</button>
    </form>
    <br>
    <a href="/history">history</a>
    <br>
    <a href="/logout">logout!</a>

</body>
</html>