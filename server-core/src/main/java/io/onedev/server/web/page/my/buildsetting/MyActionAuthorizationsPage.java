package io.onedev.server.web.page.my.buildsetting;

import java.util.List;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import io.onedev.server.OneDev;
import io.onedev.server.entitymanager.UserManager;
import io.onedev.server.model.support.build.actionauthorization.ActionAuthorization;
import io.onedev.server.web.component.build.authorization.ActionAuthorizationListPanel;
import io.onedev.server.web.component.build.authorization.ActionAuthorizationsBean;

@SuppressWarnings("serial")
public class MyActionAuthorizationsPage extends MyBuildSettingPage {

	public MyActionAuthorizationsPage(PageParameters params) {
		super(params);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		ActionAuthorizationsBean bean = new ActionAuthorizationsBean();
		bean.setActionAuthorizations(getBuildSetting().getActionAuthorizations());
		add(new ActionAuthorizationListPanel("actionAuthorizations", bean) {
			
			@Override
			protected void onSaved(List<ActionAuthorization> actionAuthorizations) {
				getBuildSetting().setActionAuthorizations(actionAuthorizations);
				OneDev.getInstance(UserManager.class).save(getLoginUser());
				setResponsePage(MyActionAuthorizationsPage.class);
			}
			
		});
	}

}
