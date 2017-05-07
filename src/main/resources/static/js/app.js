// This script makes style of select the same as the option style selected
// uses jQuery. It is taken from here:
// http://jsfiddle.net/614c6cxz/8/
// original discussion on stackoverflow:
// http://stackoverflow.com/questions/15755770/change-text-color-of-selected-option-in-a-select-box
$("select").change(function(){
    $(this).removeClass($(this).attr('class'))
        .addClass($(":selected",this).attr('class'));
});

// try to show different recipes based on
// selected category
// TODO : improve this functionality by adding hidden anchor
// close to select element so that there is no manually
// defined '/recipes/?category='
$('select#select-changing-list-of-recipes').change(function () {
    // at first we check for unselected option
    // for which we redirect home
    var optionId = $(':selected', this).attr('id');
    if (optionId == "unselected-category-option") {
        window.location.href = '/recipes/'
    } else {
        // if option is not unselected we run query
        var categoryName = $(':selected', this).text();
        var queryParam = categoryName.toLowerCase();
        window.location.href = '/recipes/?category=' + queryParam;
    }
});

// function adding new question
// for now this script does not take into consideration
// adding question when there are none
$("#add-another-question-button").click(function () {
    // can add prevent default so that
    // no need to write button type=button
    // in html5
    event.preventDefault();

    // define <div> with question that we will be appending to
    var divWithLastQuestion = $(".answer-row").last();
    var divWithLastQuestion2 = $(".question-row").last();

    // get id of the last question to generate new one
    // it is kind of whacky .. but well I'm JS newbie, so
    var questionId = parseInt(
        divWithLastQuestion2
            .children('div')
            .children('p')
            .children('input')
            .attr('id')
            .split('.')[0]
            .split('questions')[1]
    );

    // TODO: add Nan check here

    // set new id
    var newQuestionId = questionId + 1;
    var newQuestionHiddenInputId = 'questions' + newQuestionId + '.id';
    var newQuestionHiddenInputName = 'questions[' + newQuestionId + '].id';
    var newQuestionInputId = 'questions' + newQuestionId + '.description';
    var newQuestionInputName = 'questions[' + newQuestionId + '].description';
    var newInputClass = 'wp-form-control wpcf7-text';

    /////////////////////////////////////////////////////////////////////////////////////

    var answerId = parseInt(
        divWithLastQuestion
            .children('div')
            .children('p')
            .children('input')
            .attr('id')
            .split('.')[0]
            .split('answers')[1]
    );

    // TODO: add Nan check here

    // set new id
    var newAnswerId = answerId + 1;var newAnswerId2 = newAnswerId + 1;var newAnswerId3 = newAnswerId2 + 1;var newAnswerId4 = newAnswerId3 + 1;
    var newAnswerHiddenInputId = 'answers' + newAnswerId + '.id';var newAnswerHiddenInputId2 = 'answers' + newAnswerId2 + '.id';var newAnswerHiddenInputId3 = 'answers' + newAnswerId3 + '.id';var newAnswerHiddenInputId4 = 'answers' + newAnswerId4 + '.id';
    var newAnswerHiddenInputName = 'answers[' + newAnswerId + '].id';var newAnswerHiddenInputName2 = 'answers[' + newAnswerId2 + '].id';var newAnswerHiddenInputName3 = 'answers[' + newAnswerId3 + '].id';var newAnswerHiddenInputName4 = 'answers[' + newAnswerId4 + '].id';
    var newAnswerInputId = 'answers' + newAnswerId + '.description';var newAnswerInputId2 = 'answers' + newAnswerId2 + '.description';var newAnswerInputId3 = 'answers' + newAnswerId3 + '.description';var newAnswerInputId4 = 'answers' + newAnswerId4 + '.description';
    var newAnswerInputName = 'answers[' + newAnswerId + '].description';var newAnswerInputName2 = 'answers[' + newAnswerId2 + '].description';var newAnswerInputName3 = 'answers[' + newAnswerId3 + '].description';var newAnswerInputName4 = 'answers[' + newAnswerId4 + '].description';


    // create new div
    var newDiv =
        "<div class='question-row' style='margin-top:50px;'>" +
        "<input type='hidden' id='" + newQuestionHiddenInputId + "' name='" +
        newQuestionHiddenInputName + "'>" +
        "<div class='prefix-20 grid-80'>" +
        "<p>" +
        "<input id='" + newQuestionInputId + "' " +
        "name='" + newQuestionInputName + "' " +
        "class='" + newInputClass + "' " +
        "placeholder='Question " + newQuestionId + "'>" +
        "</p>" +
        "</div>" +
        "</div>" +


        "<div class='answer-row'>" +
        "<input type='hidden' id='" + newAnswerHiddenInputId + "' name='" +
        newAnswerHiddenInputName + "'>" +
        "<div class='prefix-20 grid-80'>" +
        "<p>" +
        "<input id='" + newAnswerInputId + "' " +
        "name='" + newAnswerInputName + "' " +
        "class='" + newInputClass + "' " +
        "style='margin-left:50px;' " +
        "placeholder='answer...'>" +
        "</p>" +
        "</div>" +
        "</div>" +

        "<div class='answer-row'>" +
        "<input type='hidden' id='" + newAnswerHiddenInputId2 + "' name='" +
        newAnswerHiddenInputName2 + "'>" +
        "<div class='prefix-20 grid-80'>" +
        "<p>" +
        "<input id='" + newAnswerInputId2 + "' " +
        "name='" + newAnswerInputName2 + "' " +
        "class='" + newInputClass + "' " +
        "style='margin-left:50px;' " +
        "placeholder='answer...'>" +
        "</p>" +
        "</div>" +
        "</div>" +

        "<div class='answer-row'>" +
        "<input type='hidden' id='" + newAnswerHiddenInputId3 + "' name='" +
        newAnswerHiddenInputName3 + "'>" +
        "<div class='prefix-20 grid-80'>" +
        "<p>" +
        "<input id='" + newAnswerInputId3 + "' " +
        "name='" + newAnswerInputName3 + "' " +
        "class='" + newInputClass + "' " +
        "style='margin-left:50px;' " +
        "placeholder='answer...'>" +
        "</p>" +
        "</div>" +
        "</div>" +

        "<div class='answer-row'>" +
        "<input type='hidden' id='" + newAnswerHiddenInputId4 + "' name='" +
        newAnswerHiddenInputName4 + "'>" +
        "<div class='prefix-20 grid-80'>" +
        "<p>" +
        "<input id='" + newAnswerInputId4 + "' " +
        "name='" + newAnswerInputName4 + "' " +
        "class='" + newInputClass + "' " +
        "style='margin-left:50px;margin-bottom:50px;' " +
        "placeholder='answer...'>" +
        "</p>" +
        "</div>" +
        "</div>";

    // add newly created div after last one
    divWithLastQuestion.after(
        newDiv
    );

});


$("#add-another-answer-button").click(function () {
    // can add prevent default so that
    // no need to write button type=button
    // in html5
    event.preventDefault();

    // define <div> with question that we will be appending to
    var divWithLastAnswer = $(".answer-row").last();

    // get id of the last question to generate new one
    // it is kind of whacky .. but well I'm JS newbie, so
    var id = parseInt(
        divWithLastAnswer
            .children('div')
            .children('p')
            .children('input')
            .attr('id')
            .split('.')[0]
            .split('answers')[1]
    );

    // TODO: add Nan check here

    // set new id
    var newId = id + 1;
    var newHiddenInputId = 'answers' + newId + '.id';
    var newHiddenInputName = 'answers[' + newId + '].id';
    var newAnswerInputId = 'answers' + newId + '.description';
    var newAnswerInputName = 'answers[' + newId + '].description';
    var newAnswerInputClass = 'wp-form-control wpcf7-text';

    // create new div
    var newDiv =
        "<div class='answer-row'>" +
        "<input type='hidden' id='" + newHiddenInputId + "' name='" +
        newHiddenInputName + "'>" +
        "<div class='prefix-20 grid-80'>" +
        "<p>" +
        "<input id='" + newAnswerInputId + "' " +
        "name='" + newAnswerInputName + "' " +
        "class='" + newAnswerInputClass + "' " +
        // "style='margin-left:50px;' " +
        "placeholder='answer...'>" +
        "</p>" +
        "</div>" +
        "</div>";

    // add newly created div after last one
    divWithLastAnswer.after(
        newDiv
    );

});


/**
 * changes select item element inside first div
 * of ingredientRowDiv:
 * - changes id,name
 * - removes "selected" attribute from <option>-s inside select
 * @param ingredientRowDiv - link to ingredientRowDiv with everything
 * related to one ingredient
 * @param newIngredientId - id in the array of recipe.ingredients
 * of the new ingredient to be added
 */
function changeSelectItemElement(
    ingredientRowDiv,
    newIngredientId) {

    var selectItemElement =
        ingredientRowDiv
            .children('div').eq(0)
            .children('p')
            .children();

    // change select id
    selectItemElement.attr(
        'id',
        'ingredients' + newIngredientId + '.item.id'
    );

    // change select name
    selectItemElement.attr(
        'name',
        'ingredients[' + newIngredientId + '].item.id'
    );

    // remove attribute selected from option
    selectItemElement
        .children() // option
        .removeAttr('selected');

}

/**
 * changes <input> with ingredientPropertyName
 * element inside of ingredientRowDiv, inside of
 * div with indexOfDivInIngredientRow:
 * <div> - ingredientRowDiv
 *    <div></div> - div #1
 *    ...
 *    <div> - div #indexOfDivInIngredientRow
 *       <p>
 *          <input> - input with ingredientPropertyName
 *       </p>
 *    </div>
 * <div>
 * @param ingredientRowDiv
 * @param newIdOfIngredient
 * @param indexOfDivInIngredientRow
 * @param ingredientPropertyName
 */
function changeIngredientInputElement(
    ingredientRowDiv,
    newIdOfIngredient,
    indexOfDivInIngredientRow,
    ingredientPropertyName) {

    var inputElementToChange =
        ingredientRowDiv
            .children('div').eq(indexOfDivInIngredientRow)
            .children('p')
            .children();

    // change ingredient.property 'id'
    // id="ingredient'newIdOfIngredient'.ingredientPropertyName"
    inputElementToChange.attr(
        'id',
        'ingredients' + newIdOfIngredient + '.' + ingredientPropertyName
    );
    // change ingredient.property 'name'
    // name="ingredient['newIdOfIngredient'].ingredientPropertyName"
    inputElementToChange.attr(
        'name',
        'ingredients[' + newIdOfIngredient + '].' + ingredientPropertyName
    );

    // remove values, so that inputs are blank
    inputElementToChange.removeAttr('value');

}


// function adding new ingredient
$("#add-another-ingredient-button").click(function () {
    // can add prevent default so that
    // no need to write button type=button
    // in html5
    event.preventDefault();

    // define <div> with question that we will be appending to
    var divWithLastQuestion = $(".ingredient-row").last();

    // get id of the last question to generate new one
    // it is kind of whacky .. but well I'm JS newbie, so
    var id = parseInt(
        divWithLastQuestion
            .children('div')
            .children('p')
            .children('input')
            .attr('id')
            .split('.')[0]
            .split('ingredients')[1]
    );

    // TODO: add Nan check here

    // set new id
    var newId = id + 1;
    var newHiddenInputId = 'ingredients' + newId + '.id';
    var newHiddenInputName = 'ingredients[' + newId + '].id';

    var newIngredientItemInputIdField = 'ingredients' + newId + '.item';
    var newIngredientItemInputNameField = 'ingredients[' + newId + '].item';

    var newIngredientConditionInputIdField = 'ingredients' + newId + '.condition';
    var newIngredientConditionInputNameField = 'ingredients[' + newId + '].condition';

    var newIngredientQuantityInputIdField = 'ingredients' + newId + '.quantity';
    var newIngredientQuantityInputNameField = 'ingredients[' + newId + '].quantity';

    // create new div
    var newDiv =
        "<div class='question-row'>" +
        "<input type='hidden' id='" + newHiddenInputId + "' name='" +
        newHiddenInputName + "'>" +
        "<div class='prefix-20 grid-30'>" +
        "<p>" +
        "<input id='" + newIngredientItemInputIdField + "' " +
        "name='" + newIngredientItemInputNameField + "' " +
        "placeholder='item...'>" +
        "</p>" +
        "</div>" +
        "<div class='grid-30'>" +
        "<p>" +
        "<input id='" + newIngredientConditionInputIdField + "' " +
        "name='" + newIngredientConditionInputNameField  + "' " +
        "placeholder='condition...'>" +
        "</p>" +
        "</div>" +
        "<div class='grid-10 suffix-10'>" +
        "<p>" +
        "<input id='" + newIngredientQuantityInputIdField + "' " +
        "name='" + newIngredientQuantityInputNameField  + "' " +
        "placeholder='...'>" +
        "</p>" +
        "</div>"
    "</div>";

    // add newly created div after last one
    divWithLastQuestion.after(
        newDiv
    );

});


// password

/**
 * This functions checks two fields:
 * password and matching password.
 * Upon change in them, this function is
 * executed. And the return value of "checkStrength"
 * function below is added to whatever element with
 * id="result"
 */
$('#password, #match-password').keyup(function() {
    $('#result').html(checkStrength($('#password').val()))
});

/**
 * This functions checks whether password is
 * weak, short, good or strong. The main part of the code
 * was taken from here:
 * https://www.formget.com/password-strength-checker-in-jquery/
 * I changed by adding change of "Sign-up" button "disabled"/"enabled"
 * attribute. Unless user typed "Strong" password and Password match
 * the password in "#match-password" element, button will not
 * appear
 * @param password : value of "input" with id="password"
 * @returns {*} String with message to be passed to
 * HTML element with id="result"
 */
function checkStrength(password) {
    var strength = 0;
    var result = $('#result');
    var signUpButton = $('#sign-up-button');
    if (password.length < 6) {
        result.removeClass();
        result.addClass('short');
        signUpButton.attr('disabled', 'disabled');
        return 'Too short'
    }
    if (password.length > 7) strength += 1;
    // If password contains both lower and uppercase characters, increase strength value.
    if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1;
    // If it has numbers and characters, increase strength value.
    if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1;
    // If it has one special character, increase strength value.
    if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
    // If it has two special characters, increase strength value.
    if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
    // Calculated strength value, we can return messages
    // If value is less than 2
    if (strength < 2) {
        result.removeClass();
        result.addClass('weak');
        signUpButton.attr('disabled', 'disabled');
        return 'Weak'
    } else if (strength == 2) {
        result.removeClass();
        result.addClass('good');
        signUpButton.attr('disabled', 'disabled');
        return 'Good'
    } else {
        result.removeClass();
        result.addClass('strong');

        // check for password in repeat password field
        // they should match. If not, error message appear
        var password = $("#password").val();
        var matchPassword = $("#match-password").val();
        if (matchPassword != password) {
            signUpButton.attr('disabled', 'disabled');
            return "Passwords do not Match"
        } else {
            signUpButton.removeAttr('disabled');
            signUpButton.attr('enabled', 'enabled');
            return 'Strong'
        }
    }
}