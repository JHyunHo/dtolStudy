<template>
    <div class="hello" ref="chartdiv" />
</template>
  
<script>
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";

am4core.useTheme(am4themes_animated);

export default {
    name: 'BarChartVue',
    props : {
        propChartData : Array
    },
    /* AS - IS */
    // mounted() {
    //     console.log(this.propChartData)
    //     this.chart = am4core.create(this.$refs.chartdiv, am4charts.XYChart);
    // },
    // beforeUpdate() {
    //     this.chart.legend = new am4charts.Legend()
    //     this.chart.legend.position = 'top'
    //     this.chart.legend.paddingBottom = 20
    //     this.chart.legend.labels.template.maxWidth = 95

    //     let xAxis = this.chart.xAxes.push(new am4charts.CategoryAxis())
    //     xAxis.dataFields.category = 'sub_sta_nm'
    //     xAxis.renderer.cellStartLocation = 0.1
    //     xAxis.renderer.cellEndLocation = 0.9
    //     xAxis.renderer.grid.template.location = 0;

    //     let yAxis = this.chart.yAxes.push(new am4charts.ValueAxis());
    //     yAxis.min = 0;

    //     function createSeries(value, name) {
    //         let series = this.chart.series.push(new am4charts.ColumnSeries())
    //         series.dataFields.valueY = value
    //         series.dataFields.categoryX = 'sub_sta_nm'
    //         series.name = name

    //         let bullet = series.bullets.push(new am4charts.LabelBullet())
    //         bullet.interactionsEnabled = false
    //         bullet.dy = 30;
    //         bullet.label.text = '{valueY}'
    //         bullet.label.fill = am4core.color('#ffffff')

    //         return series;
    //     }

    //     createSeries('ride_pasgr_num', '승차객 수');
    //     createSeries('alight_pasgr_num', '하차객 수');

    //     this.chart.data = this.chartData
    // },
    methods : {
        /* TO-BE */
        renderChart(val) {
            let chart = am4core.create(this.$refs.chartdiv, am4charts.XYChart);

            chart.legend = new am4charts.Legend()
            chart.legend.position = 'top'
            chart.legend.paddingBottom = 20
            chart.legend.labels.template.maxWidth = 95

            let xAxis = chart.xAxes.push(new am4charts.CategoryAxis())
            xAxis.dataFields.category = 'sub_sta_nm'
            xAxis.renderer.cellStartLocation = 0.1
            xAxis.renderer.cellEndLocation = 0.9
            xAxis.renderer.grid.template.location = 0;

            let yAxis = chart.yAxes.push(new am4charts.ValueAxis());
            yAxis.min = 0;

            function createSeries(value, name) {
                let series = chart.series.push(new am4charts.ColumnSeries())
                series.dataFields.valueY = value
                series.dataFields.categoryX = 'sub_sta_nm'
                series.name = name

                let bullet = series.bullets.push(new am4charts.LabelBullet())
                bullet.interactionsEnabled = false
                bullet.dy = 30;
                bullet.label.text = '{valueY}'
                bullet.label.fill = am4core.color('#ffffff')

                return series;
            }

            createSeries('ride_pasgr_num', '승차객 수');
            createSeries('alight_pasgr_num', '하차객 수');

            chart.data = val
        }
    }, 
    /* 
        computed VS watch
        computed : 반응형 getter
        watch    : 반응형 callback
    */
    watch : {
        propChartData() {
            // this.chartData = this.$props.propChartData
            return this.renderChart(this.$props.propChartData)
        }
    }
    // beforeDestroy() {
    //     if (this.chart) {
    //         this.chart.dispose();
    //     }
    // },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
width: 100%;
height: 500px;
}
</style>