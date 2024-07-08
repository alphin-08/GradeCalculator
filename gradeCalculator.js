function calculateGrade() {
    var assignments = [];
    var grades = [];
    var weights = [];
    var finalGradeGoal = parseFloat(document.getElementById('finalGradeGoal').value);

    for (var i = 1; i <= 8; i++) {
        var assignmentName = document.getElementById('assignmentName' + i).value;
        var grade = parseFloat(document.getElementById('grade' + i).value);
        var weight = parseFloat(document.getElementById('weight' + i).value);

        if (assignmentName && !isNaN(grade) && !isNaN(weight)) {
            assignments.push(assignmentName);
            grades.push(grade);
            weights.push(weight);
        }
    }

    var totalWeight = 0;
    var totalWeightedPtsEarned = 0;

    for (var j = 0; j < weights.length; j++) {
        totalWeight += weights[j];
        totalWeightedPtsEarned += (weights[j] / 100 * grades[j]);
    }

    var remainingWeight = 100 - totalWeight;
    var remainingWeight2 = remainingWeight / 100;

    var finalGradeNeeded = finalGradeGoal - totalWeightedPtsEarned;
    var gradeNeeded = finalGradeNeeded / remainingWeight2;

    var resultElement = document.getElementById('result');

    if (gradeNeeded > 0) {
        resultElement.textContent = "A grade of " + gradeNeeded.toFixed(2) + " is needed for the remaining " +
            remainingWeight.toFixed(2) + " of tasks to achieve a final grade of " + finalGradeGoal.toFixed(2);
    } else {
        resultElement.textContent = "A grade of " + finalGradeGoal.toFixed(2) + " will be achieved even if 0 is attained for the remaining " +
            remainingWeight.toFixed(2) + " of tasks";
    }
}

function clearInputs() {
    var inputs = document.querySelectorAll('.grid-input');
    inputs.forEach(function(input) {
        input.value = '';
    });

    document.getElementById('finalGradeGoal').value = '';
    document.getElementById('remainingWeight').value = '';

    document.getElementById('result').textContent = '';
}


function clearSecondPageInputs() {
    var inputs = document.querySelectorAll('#secondPage .grid-input2');
    inputs.forEach(function(input) {
        input.value = '';
    });
}


function calculateFinalGrade() {
   
}