SUMMARY = "my-image recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb
IMAGE_BOOT_FILES:append = " waveshare35b-v2.dtbo;overlays/waveshare35b-v2.dtbo"

IMAGE_INSTALL:append = " \
    kernel-module-ads7846 \
    util-linux-lsblk \
    util-linux-findmnt \
    qtbase \
    qtbase-plugins \
    boost \
    systemanalyzer \
    qtfbsettings \
    swupdate \
    libubootenv-bin \
    u-boot \
"

IMAGE_FSTYPES:append = " wic ext4.gz"
IMAGE_NAME_SUFFIX = ""
WKS_FILE = "image.wks"