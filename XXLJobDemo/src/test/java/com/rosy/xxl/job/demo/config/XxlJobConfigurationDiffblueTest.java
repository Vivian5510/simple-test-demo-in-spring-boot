package com.rosy.xxl.job.demo.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {XxlJobConfiguration.class})
@ExtendWith(SpringExtension.class)
class XxlJobConfigurationDiffblueTest {
    @Autowired
    private XxlJobConfiguration xxlJobConfiguration;

    /**
     * Test {@link XxlJobConfiguration#xxlJobSpringExecutor()}.
     * <p>
     * Method under test: {@link XxlJobConfiguration#xxlJobSpringExecutor()}
     */
    @Test
    @DisplayName("Test xxlJobSpringExecutor()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testXxlJobSpringExecutor() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: field 'timeout'
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange and Act
        // TODO: Populate arranged inputs
        XxlJobSpringExecutor actualXxlJobSpringExecutorResult = this.xxlJobConfiguration.xxlJobSpringExecutor();

        // Assert
        // TODO: Add assertions on result
    }
}
