@import  exercise.dto.users.UserPage
@param UserPage page

<main>
    <p>${page.getUser().getFirstName()}</p>
    <p>${page.getUser().getLastName()}</p>
    <p>${page.getUser().getEmail()}</p>

</main>