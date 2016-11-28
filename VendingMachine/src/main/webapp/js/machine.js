var moneyInMachine = 0;

$(document).ready(function () {

    loadItems();

    $('#money').text(moneyInMachine.toFixed(2));

    $('#dollar').click(function (event) {
        moneyInMachine += 1;
        moneyInMachine.toFixed(2);
        $('#money').text(moneyInMachine.toFixed(2));
    });
    $('#quarter').click(function (event) {
        moneyInMachine += .25;
        moneyInMachine.toFixed(2);
        $('#money').text(moneyInMachine.toFixed(2));

    });
    $('#dime').click(function (event) {
        moneyInMachine += .10;
        moneyInMachine.toFixed(2);
        $('#money').text(moneyInMachine.toFixed(2));

    });
    $('#nickel').click(function (event) {
        moneyInMachine += .05;
        moneyInMachine.toFixed(2);
        $('#money').text(moneyInMachine.toFixed(2));

    });
    $('#penny').click(function (event) {
        moneyInMachine += .01;
        moneyInMachine.toFixed(2);
        $('#money').text(moneyInMachine.toFixed(2));

    });
});

function fillItemTable(data, status) {
    clearItemTable();
    var iDiv = $('#items');
    $.each(data, function (index, item) {
        iDiv.append($('<div>').html(item.name + '<br>$' + item.cost + '<br>' + item.numberInInventory).attr({
            'class': 'col-xs-4 item',
            'onClick': 'subtractItem(' + item.id + ',' + item.cost + ',' + item.numberInInventory + ',"' + item.name + '")'
        }));
    });
}

function loadItems() {
    $.ajax({
        url: "items"
    }).success(function (data, status) {
        fillItemTable(data, status);
    });
}

function clearItemTable() {
    $('#items').empty();
}

function subtractItem(id, cost, numberInInventory, name) {

    var cash = $('#money').text();

    if (cash >= cost && numberInInventory > 0) {
        $.ajax({
            type: 'PUT',
            url: 'item/' + id,
            data: JSON.stringify({
                name: name,
                cost: cost,
                numberInInventory: numberInInventory - 1
            }),
            headers: {
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            $('#money').text(0);
            moneyInMachine = 0;
            $("#messages").text('Your change is $' + (cash - cost).toFixed(2));
            setTimeout(clearMessage, 3000);
            loadItems();
        });
    } else if (numberInInventory <= 0) {
        $("#messages").text('Out of stock!');
        setTimeout(clearMessage, 3000);
    } else {
        $("#messages").text('Not enough money!');
        setTimeout(clearMessage, 3000);
    }
}

function clearMessage() {
    $("#messages").text('');
}
