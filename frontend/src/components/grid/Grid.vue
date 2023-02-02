<template>
    <ag-grid-vue
      style="width: 734px; height: 570px"
      class="ag-theme-alpine"
      :columnDefs="columnDefs"
      :rowData="rowData"
    >
    </ag-grid-vue>
   </template>
   
   <script>
   import { AgGridVue } from "ag-grid-vue";
   
   export default {
    name: "GridVue",
    props : {
        propColumnDefs : Array,
        propRowData : Array
    },
    components: {
      AgGridVue,
    },
    beforeMount() {
        // fetch('https://www.ag-grid.com/example-assets/small-row-data.json')
        //         .then(result => result.json())
        //         .then(rowData => this.rowData = rowData);
    },
    computed : {
        columnDefs() {
            return this.$props.propColumnDefs
        },
        rowData() {
            return this.$props.propRowData
        }
    }
   };
   </script>
   <style lang="scss">
    @import "~ag-grid-community/styles/ag-grid.css";
    @import "~ag-grid-community/styles/ag-theme-alpine.css";
   </style>