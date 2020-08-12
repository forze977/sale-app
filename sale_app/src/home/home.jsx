import React from 'react';
import { Nav, Navbar, NavDropdown, Form, FormControl, Button, Table, Container, Row, Col, InputGroup, Modal } from 'react-bootstrap';
import Delete from './Modal/Delete';
import Submit from './Modal/Submit';
import SockJsClient from 'react-stomp';

class Home extends React.PureComponent {
  state = {
    showDeleteModal: false,
    showSubmitModal: false,
    tableData: [],
    orderName: ""
  }
  render() {
    return (
      <div>
        <SockJsClient url='http://localhost:8080/zengcode-websocket/' topics={['/topic/messages']}
          onMessage={(msg) => { console.log(msg); }}
          ref={(client) => { this.clientRef = client }} />
        <Delete show={this.state.showDeleteModal} onConfirm={() => this.setState({ showDeleteModal: false })} onCancel={() => this.setState({ showDeleteModal: false })} />
        <Submit show={this.state.showSubmitModal} onConfirm={() => this.setState({ showSubmitModal: false })} onCancel={() => this.setState({ showSubmitModal: false })} />
        <Navbar bg="dark" variant="dark">
          <Navbar.Brand>Brand text</Navbar.Brand>
        </Navbar>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>#</th>
              <th>Order</th>
              <th>Amount</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {this.state.tableData.map((value, index) => {
              return (
                <tr key={`${JSON.stringify(value)}${index}`}>
                  <td>{index + 1}</td>
                  <td>{value.order}</td>
                  <td>{value.amount}</td>
                  <td><Button onClick={() => {
                    this.state.tableData.splice(index, 1)
                    this.forceUpdate()
                  }}>del</Button></td>
                </tr>
              )
            })}
          </tbody>
        </Table>
        <div style={{ paddingLeft: 16, paddingRight: 16 }}>
          <InputGroup className="mb-3">
            <FormControl
              placeholder="Order's Name"
              aria-label="Order's Name"
              aria-describedby="basic-addon2"
              onChange={(event) => this.setState({ orderName: event.target.value })}
              value={this.state.orderName}
              onSubmit={() => this.setState({ orderName: "", tableData: [...this.state.tableData, { order: this.state.orderName, amount: 1 }] })}
            />
            <InputGroup.Append>
              <Button variant="outline-secondary" onClick={() => this.setState({ orderName: "", tableData: [...this.state.tableData, { order: this.state.orderName, amount: 1 }] })}>Add</Button>
            </InputGroup.Append>
          </InputGroup>
          <Button block onClick={() => this.setState({ showSubmitModal: true })}>Submit</Button>
        </div>
      </div>
    )
  }
}

export default Home;