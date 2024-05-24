@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hexlet Javalin Example</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <a href="/">Home</a>
    <a href="/users">Users</a>
</div>
${content}

<div class="mx-auto p-4 py-md-5">
    <a href="https://github.com/Barlog7">Github link</a>
</div>

</body>
</html>
