const ROUTE = 'api/registerCard';

async function submitCard() {
    console.log("submitting card");
    // scrape user's inputs
    let requestBody = {
        'bankName': document.getElementById("bankName").value,
        'cardNumber': document.getElementById("cardNumber").value,
        'expiryDate': document.getElementById("expiryDate").value,
    };
    console.log(requestBody)

    // perform rest call
    let response = await postRequest(ROUTE, requestBody);
    let responseBody = await response.json();
    console.log(response.status);
    console.log(responseBody)

    // feedback to the user
    if(response.status === 200) {
        alert("card " + responseBody.cardNumber + " submitted successfully");
    } else {
        alert("card " + requestBody.cardNumber + " submission failed");
    }
}

function postRequest(route, bodyParams) {
    return fetch('api/registerCard', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyParams),
    });
}


document.getElementById("submitButton")
    .addEventListener('click', submitCard);
