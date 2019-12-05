package com.composum.sling.core;

import org.apache.sling.api.resource.Resource;

/**
 * The interface for 'Beans' to implement a Model based on e JCR resource without a mapping framework. Such a 'bean' can
 * be declared as variable in a JSP context using the 'component' tag of the Composum 'nodes' tag library (cpnl).
 */
public interface SlingBean {

    /**
     * This basic initialization sets up the context and resource attributes only, all the other attributes are set
     * 'lazy' during their getter calls.
     * <p>
     * You might want to consider using {@link #initialize(BeanContext)} after {@link BeanContext#withResource(Resource)},
     * which should be the same thing.
     *
     * @param context  the scripting context (e.g. a JSP PageContext or a Groovy scripting context)
     * @param resource the resource to use (normally the resource addressed by the request)
     * @see BeanContext#withResource(Resource)
     * @deprecated please use {@link BeanContext#withResource(Resource)}.{@link BeanContext#adaptTo(Class)} with the needed
     * SlingBean class to instantiate the object, since {@link #initialize(BeanContext, Resource)} doesn't initialize
     * fields injected by Sling-Models.
     */
    @Deprecated
    void initialize(BeanContext context, Resource resource);

    /**
     * Uses the context for initialization - must call the 'main' initialization - initialize(context,resource) - with
     * the resource determined from the context.
     *
     * @param context the scripting context (e.g. a JSP PageContext or a Groovy scripting context)
     * @deprecated please use {@link BeanContext#adaptTo(Class)} with the needed SlingBean class to instantiate the
     * object, since {@link #initialize(BeanContext)} doesn't initialize fields injected by Sling-Models.
     */
    @Deprecated
    void initialize(BeanContext context);

    /**
     * returns the name of the resource wrapped by this bean
     */
    String getName();

    /**
     * returns the path of the resource wrapped by this bean
     */
    String getPath();

    /**
     * returns the type of the resource wrapped by this bean
     */
    String getType();
}
