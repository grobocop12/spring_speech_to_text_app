const bufferLength = 1024;
const cutting = 2;
const zeros = new Array(bufferLength);
let yData = new Array(bufferLength);
const ctx = document.getElementById("chart").getContext('2d');
const chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: Array.from(Array(Math.floor(bufferLength / cutting)).keys()),
        datasets: [
            {
                data: yData,
                backgroundColor: [
                    'rgba(255, 99, 132, 1)',

                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                ],
                fill: false
            }]
    },
    options: {
        scales: {
            yAxes: [{
                display: false,
                ticks: {
                    max: 0.6,
                    min: -0.6,
                    stepSize: 0.1
                },
                gridLines: {
                    display: false
                }
            }],
            xAxes: [{
                display: false,
                gridLines: {
                    display: false
                }
            }]
        },
        elements: {
            line: {
                tension: 1
            }
        },
        legend: {
            display: false,
        },
        tooltips: {enabled: false},
        hover: {mode: null}
    }
})