import { Form, Select, Divider, Button } from "antd";
import { useEffect, useState } from "react";
import { getUserPrefrenceOptions, saveUserPrefrences } from "../../services/UserPrefrenceService";
import './style.css'

const UserPreference = () => {
  const [preferencesOptions, setPreferencesOption] = useState([]);

  useEffect(() => {
    fetchUserPrefenceOptions();
  }, []);

  const fetchUserPrefenceOptions = async () => {
    const response = await getUserPrefrenceOptions();
    // setPreferencesOption(response.data);
  };

  const filterLoopOptions = (options) => {
    return options.map((option) => {
      return { value: option.prefId, label: option.optionName };
    });
  }

  const renderByLoop = (type) => {
    return preferencesOptions.map((option) => {
      if (option.type === type) {
        return (
          <Form.Item
            name={option.prefId}
            label={option.name}
            rules={[{ required: true, message: `Please Select ${option.name}!` }]}
          >
            <Select
              placeholder={`Select ${option.name}`}
              options={filterLoopOptions(option.options)}
            ></Select>
          </Form.Item>
        );
      }
      else{
        return null;
      }
    });
  };

  const onFormFinish = (values) => {
    const reqData = [];
    for (const property in values) {
      reqData.push({prefNameId:property,prefOptionId:values[property]})
      // reqData.push({prefName:{prefNameId:property},prefOption:{prefOptionId:values[property]}})
    }
    saveUserPrefrences(reqData);
  };

  const renderForm = () => (
    <Form
      name="userPrefrenceForm"
      labelCol={{ span: 7 }}
      wrapperCol={{ span: 17 }}
      onFinish={onFormFinish}
    >
      <Divider orientation="left" plain>
        Properety Preferences
      </Divider>
      {renderByLoop("Properety Preferences")}
      <Divider orientation="left" plain>
        Roommate Preferences
      </Divider>
      {renderByLoop("Roommate Preferences")}
      <Form.Item wrapperCol={{ offset: 6, span: 18 }}>
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
      </Form.Item>
    </Form>
  );

  return (
    <div className="form">
      {preferencesOptions && preferencesOptions.length > 0 && renderForm()}
    </div>
  );
};

export default UserPreference;
