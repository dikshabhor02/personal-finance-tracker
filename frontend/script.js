const API_URL = "http://localhost:8080/expenses";
let editingExpenseId = null;

// Load expenses on page load
window.onload = loadExpenses;

function applyFilter() {
    const category = document.getElementById("filterCategory").value;
    const from = document.getElementById("fromDate").value;
    const to = document.getElementById("toDate").value;

    let url = API_URL + "/filter?";

    if (category) {
        url += `category=${category}`;
    } else if (from && to) {
        url += `from=${from}&to=${to}`;
    } else {
        alert("Please select a category or date range");
        return;
    }

    fetch(url)
        .then(res => res.json())
        .then(data => renderTable(data));
}

function clearFilter() {
    document.getElementById("filterCategory").value = "";
    document.getElementById("fromDate").value = "";
    document.getElementById("toDate").value = "";
    loadExpenses();
}

// reuse table rendering logic
function renderTable(data) {
    const table = document.getElementById("expenseTable");
    table.innerHTML = "";
    let total = 0;

    data.forEach(exp => {
        total += exp.amount;
        table.innerHTML += `
            <tr>
                <td>${exp.title}</td>
                <td>${exp.amount}</td>
                <td>${exp.category}</td>
                <td>${exp.date}</td>
                <td>
                    <button onclick="editExpense(${exp.id})">Edit</button>
                    <button onclick="deleteExpense(${exp.id})">Delete</button>
                </td>
            </tr>
        `;
    });

    document.getElementById("total").innerText = total;
}


function loadExpenses() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("expenseTable");
            table.innerHTML = "";
            let total = 0;

            data.forEach(expense => {
                total += expense.amount;

                table.innerHTML += `
                    <tr>
                        <td>${expense.title}</td>
                        <td>${expense.amount}</td>
                        <td>${expense.category}</td>
                        <td>${expense.date}</td>
                        <td>
                            <button onclick="editExpense(${expense.id})">Edit</button>
                            <button onclick="deleteExpense(${expense.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });

            document.getElementById("total").innerText = total;
        });
}

// ADD or UPDATE expense
function saveExpense() {
    const expense = {
        title: document.getElementById("title").value,
        amount: parseFloat(document.getElementById("amount").value),
        category: document.getElementById("category").value,
        date: document.getElementById("date").value
    };

    if (editingExpenseId === null) {
        // ADD
        fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(expense)
        }).then(loadExpenses);
    } else {
        // UPDATE
        fetch(`${API_URL}/${editingExpenseId}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(expense)
        }).then(() => {
            editingExpenseId = null;
            document.getElementById("addBtn").innerText = "Add Expense";
            loadExpenses();
        });
    }

    clearForm();
}

// DELETE expense
function deleteExpense(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    }).then(loadExpenses);
}

// EDIT expense
function editExpense(id) {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(expense => {
            document.getElementById("title").value = expense.title;
            document.getElementById("amount").value = expense.amount;
            document.getElementById("category").value = expense.category;
            document.getElementById("date").value = expense.date;

            editingExpenseId = expense.id;
            document.getElementById("addBtn").innerText = "Update Expense";
        });
}

// Clear form
function clearForm() {
    document.getElementById("title").value = "";
    document.getElementById("amount").value = "";
    document.getElementById("category").value = "";
    document.getElementById("date").value = "";
}






//const API_URL = "http://localhost:8080/expenses";
//
//// Load expenses on page load
//window.onload = function () {
//    loadExpenses();
//};
//
//// ADD EXPENSE
//async function addExpense() {
//    const title = document.getElementById("title").value.trim();
//    const amount = document.getElementById("amount").value;
//    const category = document.getElementById("category").value.trim();
//    const date = document.getElementById("date").value;
//
//    if (!title || !amount || !category || !date) {
//        alert("Please fill all fields");
//        return;
//    }
//
//    const expense = {
//        title: title,
//        amount: Number(amount),
//        category: category,
//        date: date
//    };
//
//    console.log("POSTING:", expense);
//
//    try {
//        await fetch(API_URL, {
//            method: "POST",
//            headers: {
//                "Content-Type": "application/json"
//            },
//            body: JSON.stringify(expense)
//        });
//
//        clearForm();
//        loadExpenses();
//
//    } catch (error) {
//        console.error("Error adding expense:", error);
//    }
//}
//
//// LOAD EXPENSES
//async function loadExpenses() {
//    try {
//        const response = await fetch(API_URL);
//        const expenses = await response.json();
//
//        const table = document.getElementById("expenseTable");
//        table.innerHTML = "";
//
//        let total = 0;
//
//        expenses.forEach(exp => {
//            total += exp.amount;
//
//            table.innerHTML += `
//                <tr>
//                    <td>${exp.title}</td>
//                    <td>${exp.amount}</td>
//                    <td>${exp.category}</td>
//                    <td>${exp.date}</td>
//                    <td>
//                        <button onclick="deleteExpense(${exp.id})">Delete</button>
//                    </td>
//                </tr>
//            `;
//        });
//
//        document.getElementById("total").innerText = total;
//
//    } catch (error) {
//        console.error("Error loading expenses:", error);
//    }
//}
//
//// DELETE EXPENSE
//async function deleteExpense(id) {
//    try {
//        await fetch(`${API_URL}/${id}`, {
//            method: "DELETE"
//        });
//        loadExpenses();
//    } catch (error) {
//        console.error("Error deleting expense:", error);
//    }
//}
//
//// CLEAR FORM
//function clearForm() {
//    document.getElementById("title").value = "";
//    document.getElementById("amount").value = "";
//    document.getElementById("category").value = "";
//    document.getElementById("date").value = "";
//}
