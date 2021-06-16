// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
var ctx = document.getElementById("myBarChart");

var crLabels = $("#crLabels").val();
crLabels = crLabels.split(",");

var crRevenue = $("#crRevenue").val();
crRevenue = crRevenue.split(",");
crRevenue[0] = crRevenue[0].slice(start=1);
crRevenue[crRevenue.length - 1] = crRevenue[crRevenue.length-1].slice(end=-2);

var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: crLabels,
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: crRevenue,
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 15000,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
