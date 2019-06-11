import React, { Component } from 'react';
import MaterialTable from 'material-table';

export default class StatusViewer extends Component {

  componentDidMount() {
    this.loadData();
    setInterval(this.loadData, 60000);
  }
  constructor(props) {
    super(props);
    this.loadData = this.loadData.bind(this);
    this.state = {
      columns: [
        { title: 'User Name', field: 'name' },
        { title: 'User Address', field: 'address' },
        { title: 'Vehicle Id', field: 'vehicleId'},
        { title: 'Vehicle Register Number', field: 'regNum'},
        { title: 'Vehicle Status', field: 'connected', type: 'boolean'}
      ],
      data: [
      ]
    };
  }

  render() {
    return (
      <MaterialTable
        title="Vehicle Status Displayer"
        columns={this.state.columns}
        options={{
          filtering: true
        }}
        data={this.state.data}
      />
    );
  }

  async loadData() {
    try {
      const res = await fetch('http://localhost:8762/STATUS-CHECKER/statusChecker/checkStatusOfVehicles');
      const blocks = await res.json();
      const userVehicleStatus = [];
      blocks.forEach(item => {
        const userVehicleStatusItem = {
          'name': item.userName,
          'address': item.userAddress,
          'vehicleId': item.vehicleId,
          'regNum': item.vehicleRegNumber,
          'connected': item.vehicleStatus

        };
        userVehicleStatus.push(userVehicleStatusItem);
      })
      console.log();
      this.setState({
        data: userVehicleStatus
      });
    } catch (e) {
      console.log(e);
    }
  };

}
