
<form id="form1" name="form1" method="post" action="view_schedules2.jsp">
  <label>Term
  <select name="term" id="term">
    <option value="Spring 2007" selected="selected">Spring 2007</option>
    <option value="Summer 2007">Summer 2007</option>
  </select>
  </label>
  <label></label>
  <label>course1
  <input name="course1" type="text" id="course1" value="" />
  </label>
  <label>course2
  <input name="course2" type="text" id="course2" value="" />
  </label>
  <label>course3
  <input name="course3" type="text" id="course3" value="" />
  </label>
  <label>course4
  <input name="course4" type="text" id="course4" value="" />
  </label>
  <label>course5
  <input name="course5" type="text" id="course5" value="" />
  </label>
  <label>course6
  <input name="course6" type="text" id="course6" value="" />
  </label>
  <label>campus
  <select name="campus" id="campus">
    <option value="All" selected="selected">All</option>
    <option value="Biscayne">Biscayne</option>
    <option value="University">University</option>
  </select>
  </label>
  <table id="week">
    <tr>
      <td align="center" valign="middle">&nbsp;  <label>No Class on: </label></td>
      <td align="center" valign="middle">M</td>
      <td align="center" valign="middle">T</td>
      <td align="center" valign="middle">W</td>
      <td align="center" valign="middle">Th</td>
      <td align="center" valign="middle">F</td>
      <td align="center" valign="middle">S</td>
      <td align="center" valign="middle">Su</td>
    </tr>
    <tr>
      <td align="center" valign="middle">&nbsp;</td>
      <td align="center" valign="middle">        <input name="m" type="checkbox" id="m" value="0" />      </td>
      <td align="center" valign="middle">        <input name="t" type="checkbox" id="t" value="0" />      </td>
      <td align="center" valign="middle">        <input name="w" type="checkbox" id="w" value="0" />      </td>
      <td align="center" valign="middle">        <input name="th" type="checkbox" id="th" value="0" />      </td>
      <td align="center" valign="middle">        <input name="f" type="checkbox" id="f" value="0" />      </td>
      <td align="center" valign="middle">        <input name="s" type="checkbox" id="s" value="0" />      </td>
      <td align="center" valign="middle">        <input name="su" type="checkbox" id="su" value="0" />      </td>
    </tr>
  </table>
  <label>Gap
  <input name="gap" type="text" id="gap" size="7" /> Hours
  </label>
  <label>
  <input type="submit" name="Submit" value="Submit" />
  </label>
</form>
